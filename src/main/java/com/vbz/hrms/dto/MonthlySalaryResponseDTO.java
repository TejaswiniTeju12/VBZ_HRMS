package com.vbz.hrms.dto;

import java.math.BigDecimal;

public class MonthlySalaryResponseDTO {

    private BigDecimal totalSalary;
    private BigDecimal actualSalary;
    private Integer totalWorkingDays;
    private Integer totalDays;

    public MonthlySalaryResponseDTO(
            BigDecimal totalSalary,
            BigDecimal actualSalary,
            Integer totalWorkingDays,
            Integer totalDays) {
        this.totalSalary = totalSalary;
        this.actualSalary = actualSalary;
        this.totalWorkingDays = totalWorkingDays;
        this.totalDays = totalDays;
    }

    public BigDecimal getTotalSalary() {
        return totalSalary;
    }

    public BigDecimal getActualSalary() {
        return actualSalary;
    }

    public Integer getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public Integer getTotalDays() {
        return totalDays;
    }
}
