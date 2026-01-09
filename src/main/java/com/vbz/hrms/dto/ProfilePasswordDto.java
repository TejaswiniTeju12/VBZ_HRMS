package com.vbz.hrms.dto;

import lombok.Data;

@Data
public class ProfilePasswordDto {
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
