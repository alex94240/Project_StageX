package com.stagex.bean;

import com.stagex.annotation.*;

@Entity("webuser")
public class WebUser {
	@Id("userId")
	private int userId;
	
	@Id("login")
	private String login;
	
	@Column("password")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
