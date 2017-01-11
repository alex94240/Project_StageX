package com.stagex.bean;

import com.stagex.annotation.Column;
import com.stagex.annotation.Entity;
import com.stagex.annotation.Id;

@Entity("teacher")
public class Teacher {
	@Id("teacherId")
	private int teacherId;
	
	@Column("userId")
	private int userId;
	
	@Column("firstName")
	private String firstName;
	
	@Column("lastName")
	private String lastName;
	
	@Column("subject")
	private String subject;
	
	@Column("email")
	private String email;
	
	@Column("telphone")
	private String telphone;
	
	@Column("type")
	private String type;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
