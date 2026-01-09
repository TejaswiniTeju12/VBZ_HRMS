package com.vbz.hrms.Service;

import com.vbz.hrms.dto.MonthlySalaryRequestDTO;
import com.vbz.hrms.dto.MonthlySalaryResponseDTO;

public interface MonthlySalaryService {

    MonthlySalaryResponseDTO calculateAndSave(MonthlySalaryRequestDTO dto);
}
