package com.zycus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLogEntity {
	@Id
	private Long id;
	
	@Column(name="loggedUser")
	private String user;
	private Date date;
	private Long account;
	private String message;
	
	public AuditLogEntity(Long id, String user, Date date, Long account, String message) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.account = account;
		this.message = message;
	}

	public AuditLogEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
