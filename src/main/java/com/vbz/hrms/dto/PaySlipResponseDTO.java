package com.vbz.hrms.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaySlipResponseDTO {

    private String name;
    private String department;
    private String designation;
    private String location;
    private LocalDate dateOfJoining;

    private String bankName;
    private String accountNumber;
    
    private String pfNo;
    private String esiNo;

    private Integer month;
    private Integer year;
    private Integer totalDays;
    private Integer workedDays;

    private BigDecimal basic;
    private BigDecimal hra;
    private BigDecimal conveyance;

    private BigDecimal pf;

    private BigDecimal totalEarnings;
    private BigDecimal totalDeductions;
    private BigDecimal netPay;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPfNo() {
		return pfNo;
	}
	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}
	public String getEsiNo() {
		return esiNo;
	}
	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
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
	public Integer getWorkedDays() {
		return workedDays;
	}
	public void setWorkedDays(Integer workedDays) {
		this.workedDays = workedDays;
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
	public BigDecimal getConveyance() {
		return conveyance;
	}
	public void setConveyance(BigDecimal conveyance) {
		this.conveyance = conveyance;
	}
	public BigDecimal getPf() {
		return pf;
	}
	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}
	public BigDecimal getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(BigDecimal totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public BigDecimal getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(BigDecimal totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	public BigDecimal getNetPay() {
		return netPay;
	}
	public void setNetPay(BigDecimal netPay) {
		this.netPay = netPay;
	}

}
