package com.vbz.hrms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SalaryPercentageDTO {

    @NotNull(message = "Basic percentage is required")
    @Min(value = 0, message = "Basic percentage cannot be negative")
    @Max(value = 100, message = "Basic percentage cannot exceed 100")
    private Double basicPercent;

    @NotNull(message = "HRA percentage is required")
    @Min(value = 0, message = "HRA percentage cannot be negative")
    @Max(value = 100, message = "HRA percentage cannot exceed 100")
    private Double hraPercent;

    @NotNull(message = "PF percentage is required")
    @Min(value = 0, message = "PF percentage cannot be negative")
    @Max(value = 100, message = "PF percentage cannot exceed 100")
    private Double pfPercent;

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
  
}
