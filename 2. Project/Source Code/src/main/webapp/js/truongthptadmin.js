var dataTable = [];

$(document).ready(function () {
    $.ajax({
        url: "/truongthpts",
        type: "GET",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            dataTable = data;
            $('#example').DataTable({
                data: dataTable,
                columns: [
                    { "data": "id" },
                    { "data": "maTruong" },
                    { "data": "tenTruong" },
                    { "data": "khuVucUuTien" },
                    { "data": "diemUuTien" },
                    {
                        "data": null,
                        "defaultContent": "<button>Xóa</button>"
                    }
                ]
            });
        },
    });

    $('#example').on('click', 'tbody tr', function () {
        var data = $('#example').DataTable().row(this).data();
        console.log(data);
        for (const [key, value] of Object.entries(data)) {
            $("input[name='" + key + "']").val(value);
            if (key == "khuVucUuTien") {
                $("select[name^='" + key + "'] option[value='"+ value +"']").prop('selected', true);
            }
           
        }
        $("#btnAddUpdate").html('Cập Nhập');
    });

    $('#example').on('click', 'tbody button', function () {
        var data = $('#example').DataTable().row($(this).parents('tr')).data();
        if (confirm('Bạn Có Muốn Xóa Trường Thpt Có Id là : ' + data.id)) {
            var data = { "id": data.id };
            $.ajax({
                url: "/truongthpt",
                type: "DELETE",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    console.log("SUCCESS : ", data.kq);
                    if (data.kq == "ok") {
                        location.reload();
                    } else {

                    }
                },
            });

        } else {

            console.log('Hủy');
        }
        // alert(data.id);
    });

    $("#formhoso").extend(jQuery.validator.messages, {
        required: "Trường Không được bỏ trống. Vui lòng Điền Chính Xác Giá Trị",
    });

    $("#formhoso")
        .submit(function (e) {
            e.preventDefault();
        })
        .validate({
            onfocusout: false,
            onkeyup: false,
            onclick: false,
            rules: {
                tenTruong: {
                    required: true,
                    maxlength : 60
                },
                maTruong: {
                    required: true,
                    maxlength : 60
                },
                khuVucUuTien: {
                    required: true,
                },

            },
            messages: {
                tenTruong: {
                    maxlength: "Nhập tối đa 60 ký tự",
                },
                maTruong: {
                    maxlength: "Nhập tối đa 60 ký tự",
                },
            },
            submitHandler: function (form) {
                var formdata = $("#formhoso").serializeArray();
                var data = {};
                $(formdata).each(function (index, obj) {
                    data[obj.name] = obj.value;
                });

                if (data.id == "") {
                    $.ajax({
                        url: "/truongthpt",
                        type: "POST",
                        data: JSON.stringify(data),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (data) {
                            console.log("SUCCESS : ", data.kq);
                            if (data.kq == "ok") {
                                alert("Bạn lưu thành công");
                                location.reload();
                            } else {
                                alert("Bạn lưu không thành công");
                            }
                        },
                        error: function (e) {
                            console.log("ERROR : ", e);
                        },
                    });

                } else {
                    $.ajax({
                        url: "/truongthpt",
                        type: "PUT",
                        data: JSON.stringify(data),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function (data) {
                            console.log("SUCCESS : ", data.kq);
                            if (data.kq == "ok") {
                                alert("Bạn cập nhập thành công");
                                location.reload();
                            } else {
                                alert("Bạn cập nhập không thành công");
                            }
                        },
                        error: function (e) {
                            console.log("ERROR : ", e);
                        },
                    });

                }
                return false;
            },
        });
});
