package com.vbz.hrms.dto;


import lombok.Data;


@Data
public class DepartmentDto {
	
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
