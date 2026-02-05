package com.vbz.hrms.dto;

import java.math.BigDecimal;

import com.vbz.hrms.model.User;

import lombok.Data;

@Data
public class MonthlySalaryResponseDTO {

    private Long Id;
    private Long employeeId;
    private String employeeName;

    private Integer totalDays;
    private Integer actualWorkingDays;

    private BigDecimal basic;
    private BigDecimal hra;
    private BigDecimal conveyanceAllowance;
    private BigDecimal pf;
    private BigDecimal totalSalary;
    
    private Long generatedById;
    private String generatedByName;

    
    private Integer month;
    private Integer year;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public BigDecimal getBasic() {
		return basic;
	}
	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}
	public BigDecimal getHra() {
		return hra;
	}
	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}
	public BigDecimal getConveyanceAllowance() {
		return conveyanceAllowance;
	}
	public void setConveyanceAllowance(BigDecimal conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}
	public BigDecimal getTotalalary() {
		return totalSalary;
	}
	public void setTotalSalary(BigDecimal totalSalary) {
		this.totalSalary = totalSalary;
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
	
	public Long getGeneratedById() {
		return generatedById;
	}
	public void setGeneratedById(Long generatedById) {
		this.generatedById = generatedById;
	}
	public String getGeneratedByName() {
		return generatedByName;
	}
	public void setGeneratedByName(String generatedByName) {
		this.generatedByName = generatedByName;
	}
	public BigDecimal getPf() {
		return pf;
	}
	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}

	
}
