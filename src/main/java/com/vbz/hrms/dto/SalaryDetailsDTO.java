package com.vbz.hrms.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class SalaryDetailsDTO {

    private BigDecimal ctc;
    private BigDecimal basic;
    private BigDecimal hra;
    public BigDecimal getCtc() {
		return ctc;
	}
	public void setCtc(BigDecimal ctc) {
		this.ctc = ctc;
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
	private BigDecimal conveyanceAllowance;

    
}
