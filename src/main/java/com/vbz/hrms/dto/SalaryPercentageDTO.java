package com.vbz.hrms.dto;

public class SalaryPercentageDTO {

    private Double basicPercent;
    private Double hraPercent;
    private Double pfPercent;
    private Double conveyancePercent;
    
    
	public Double getBasicPercent() {
		return basicPercent;
	}
	public void setBasicPercent(Double basicPercent) {
		this.basicPercent = basicPercent;
	}
	public Double getHraPercent() {
		return hraPercent;
	}
	public void setHraPercent(Double hraPercent) {
		this.hraPercent = hraPercent;
	}
	public Double getPfPercent() {
		return pfPercent;
	}
	public void setPfPercent(Double pfPercent) {
		this.pfPercent = pfPercent;
	}
	public Double getConveyancePercent() {
		return conveyancePercent;
	}
	public void setConveyancePercent(Double conveyancePercent) {
		this.conveyancePercent = conveyancePercent;
	}

}
