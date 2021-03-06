package com.tutv.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * User Entity
 *
 * @author tutv
 */
@Entity
@Table(name = "users")
public class User {

	/**
	 * Property id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
	private Integer id;

	/**
	 * Property email
	 */
	@Column(name = "email", nullable = false, length = 100)
	private String email;

	/**
	 * Property emailVerifiedAt
	 */
	@Column(name = "email_verified_at", columnDefinition = "timestamp NULL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date emailVerifiedAt;

	/**
	 * Property password
	 */
	@Column(name = "password", nullable = false, length = 60)
	private String password;

	/**
	 * Property rememberToken
	 */
	@Column(name = "remember_token", length = 60)
	private String rememberToken;

	/**
	 * Property resetToken
	 */
	@Column(name = "reset_token", length = 60)
	private String resetToken;

	/**
	 * Property avatar
	 */
	@Column(name = "avatar", length = 8)
	private String avatar;

	/**
	 * Property createdAt
	 */
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	/**
	 * Property updatedAt
	 */
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "timestamp NULL")
	private Date updatedAt;

	/**
	 * Constructor
	 */
	public User() {
	}

	/**
	 * Constructor
	 */
	public User(Integer id, String email, String password, String avatar) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
	}

	/**
	 * @Get Property id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @Set Property id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @Get Property email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @Set Property email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @Get Property emailVerifiedAt
	 */
	public Date getEmailVerifiedAt() {
		return emailVerifiedAt;
	}

	/**
	 * @Set Property emailVerifiedAt
	 */
	public void setEmailVerifiedAt(Date emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	/**
	 * @Get Property password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @Set Property password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @Get Property rememberToken
	 */
	public String getRememberToken() {
		return rememberToken;
	}

	/**
	 * @Set Property rememberToken
	 */
	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	/**
	 * @Get Property resetToken
	 */
	public String getResetToken() {
		return resetToken;
	}

	/**
	 * @Set Property resetToken
	 */
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	/**
	 * @Get Property avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @Set Property avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	/**
	 * @Get Property createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @Set Property createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @Get Property updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @Set Property updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}