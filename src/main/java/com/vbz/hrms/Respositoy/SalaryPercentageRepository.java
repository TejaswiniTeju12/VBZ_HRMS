package com.vbz.hrms.Respositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vbz.hrms.model.SalaryPercentageMaster;

public interface SalaryPercentageRepository
        extends JpaRepository<SalaryPercentageMaster, Long> {
}
