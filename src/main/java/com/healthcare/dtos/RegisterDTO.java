package com.healthcare.dtos;

import com.healthcare.models.Patient;

public class RegisterDTO extends Patient {

	private String password;
	private String userid;
	private String username;

	public String getPassword() {
		return password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
