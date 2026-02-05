package com.vbz.hrms.service;

import com.vbz.hrms.dto.SalaryPercentageDTO;

public interface SalaryPercentageService {
    String savePercentage(SalaryPercentageDTO dto);
    SalaryPercentageDTO getPercentage();
}
