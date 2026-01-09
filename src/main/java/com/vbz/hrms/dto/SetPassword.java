package com.vbz.hrms.dto;

import lombok.Data;

@Data
public class SetPassword {
	
	private String oldpassword;
	private String password;
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
