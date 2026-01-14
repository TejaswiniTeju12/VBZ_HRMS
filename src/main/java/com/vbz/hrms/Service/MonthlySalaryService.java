package com.vbz.hrms.service;

import java.util.List;
import com.vbz.hrms.dto.MonthlySalaryRequestDTO;
import com.vbz.hrms.dto.MonthlySalaryResponseDTO;
import jakarta.servlet.http.HttpSession;

public interface MonthlySalaryService {

    String generateMonthlySalary(MonthlySalaryRequestDTO dto, HttpSession session);

    List<MonthlySalaryResponseDTO> getSalaryByMonthYear(Integer year, Integer month);

    List<MonthlySalaryResponseDTO> mySalary(HttpSession session);
}
