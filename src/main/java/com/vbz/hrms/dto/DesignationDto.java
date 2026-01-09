package com.vbz.hrms.dto;

import lombok.Data;

@Data
public class DesignationDto {
	
	
	private String designationName;

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

}
