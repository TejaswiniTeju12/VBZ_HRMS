package com.vbz.hrms.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MonthlySalaryRequestDTO {
    private Long userId;
    private Integer month;
    private Integer year;
    private Integer totalDays;
    private Integer actualWorkingDays;
    
    
    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}
	
	public Integer getActualWorkingDays() {
		return actualWorkingDays;
	}
	public void setActualWorkingDays(Integer actualWorkingDays) {
		this.actualWorkingDays = actualWorkingDays;
	}

}
