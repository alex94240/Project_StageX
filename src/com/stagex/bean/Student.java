package com.stagex.bean;

import com.stagex.annotation.*;

@Entity("student")
public class Student {
	@Id("studentId")
	private int studentId;
	
	@Column("userId")
	private int userId;
	
	@Column("firstName")
	private String firstName;
	
	@Column("lastName")
	private String lastName;
	
	@Column("email")
	private String email;
	
	@Column("telphone")
	private String telphone;
	
	@Column("garde")
	private String garde;
	
	@Column("address")
	private String address;
	
	@Column("motivation")
	private String motivation;
	
	@Column("cv")
	private String cv;
	
	@Column("picture")
	private String picture;
	
	@Column("socialSecruityNum")
	private String socialSecruityNum;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getGarde() {
		return garde;
	}

	public void setGarde(String garde) {
		this.garde = garde;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSocialSecruityNum() {
		return socialSecruityNum;
	}

	public void setSocialSecruityNum(String socialSecruityNum) {
		this.socialSecruityNum = socialSecruityNum;
	}
	
	public String toString(){
		String res = "";
		res += "studentId: " + getStudentId();
		res += " userId: " + getUserId();		
		res += " firstName: " + getFirstName();
		res += " lastName: " + getLastName();
		res += " email: " + getEmail();
		res += " telphone: " + getTelphone();
		res += " garde: " + getGarde();
		res += " address: " + getAddress();
		res += " motivation: " + getMotivation();
		res += " cv: " + getCv();
		res += " picture: " + getPicture();
		res += " socialSecruityNum: " + getSocialSecruityNum();
		return res;
	}

}
