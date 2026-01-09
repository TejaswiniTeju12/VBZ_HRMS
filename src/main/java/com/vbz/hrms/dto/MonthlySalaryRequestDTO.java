package com.vbz.hrms.dto;

import java.math.BigDecimal;

public class MonthlySalaryRequestDTO {

    private Long userId;
    private BigDecimal basic;
    private BigDecimal ctc;
    private BigDecimal hra;
    private BigDecimal conveyanceAllowance;
    private Integer totalWorkingDays;
    private Integer totalDays; // present days
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public BigDecimal getBasic() {
		return basic;
	}
	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}
	public BigDecimal getCtc() {
		return ctc;
	}
	public void setCtc(BigDecimal ctc) {
		this.ctc = ctc;
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
	public Integer getTotalWorkingDays() {
		return totalWorkingDays;
	}
	public void setTotalWorkingDays(Integer totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}
	public Integer getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

}