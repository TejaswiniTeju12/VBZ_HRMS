package com.vbz.hrms.dto;

import lombok.Data;

@Data
public class EmployeeStatutoryDetailsDTO {

    private String pfUan;
    public String getPfUan() {
		return pfUan;
	}
	public void setPfUan(String pfUan) {
		this.pfUan = pfUan;
	}
	public String getEsi() {
		return esi;
	}
	public void setEsi(String esi) {
		this.esi = esi;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	private String esi;
    private String min;  
}
