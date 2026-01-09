package com.vbz.hrms.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbz.hrms.dto.MonthlySalaryRequestDTO;
import com.vbz.hrms.dto.MonthlySalaryResponseDTO;
import com.vbz.hrms.model.MonthlySalary;
import com.vbz.hrms.model.SalaryDetails;
import com.vbz.hrms.model.User;
import com.vbz.hrms.Respositoy.MonthlySalaryRepository;
import com.vbz.hrms.Respositoy.SalaryDetailsRespo;
import com.vbz.hrms.Respositoy.UserResp;

@Service
@Transactional
public class MonthlySalaryServiceImpl implements MonthlySalaryService {

    private final MonthlySalaryRepository monthlySalaryRepo;
    private final UserResp userRepo;
    private final SalaryDetailsRespo salaryDetailsRespo;

    public MonthlySalaryServiceImpl(
            UserResp userRepo,
            SalaryDetailsRespo salaryDetailsRepo,
            MonthlySalaryRepository monthlySalaryRepo) {

        this.userRepo = userRepo;
        this.salaryDetailsRespo = salaryDetailsRepo;
        this.monthlySalaryRepo = monthlySalaryRepo;
    }

    @Override
    public MonthlySalaryResponseDTO calculateAndSave(MonthlySalaryRequestDTO dto) {

        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        SalaryDetails salaryDetails = salaryDetailsRespo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Salary not configured"));

        BigDecimal totalSalary = salaryDetails.getBasic()
                .add(salaryDetails.getHra())
                .add(salaryDetails.getConveyanceAllowance());

        int absentDays = dto.getTotalWorkingDays() - dto.getTotalDays();

        BigDecimal perDaySalary = totalSalary.divide(
                BigDecimal.valueOf(dto.getTotalWorkingDays()),
                2,
                RoundingMode.HALF_UP
        );

        BigDecimal deduction = perDaySalary.multiply(
                BigDecimal.valueOf(absentDays));

        BigDecimal actualSalary = totalSalary.subtract(deduction);

        MonthlySalary monthlySalary = monthlySalaryRepo.findByUser(user)
                .orElse(new MonthlySalary());

        monthlySalary.setUser(user);
        monthlySalary.setCtc(salaryDetails.getCtc());
        monthlySalary.setBasic(salaryDetails.getBasic());
        monthlySalary.setHra(salaryDetails.getHra());
        monthlySalary.setConveyanceAllowance(
                salaryDetails.getConveyanceAllowance());
        monthlySalary.setTotalWorkingDays(dto.getTotalWorkingDays());
        monthlySalary.setTotalDays(dto.getTotalDays());
        monthlySalary.setTotalSalary(totalSalary);
        monthlySalary.setActualSalary(actualSalary);

        monthlySalaryRepo.save(monthlySalary);

        // ✅ RETURN DTO (NOT ENTITY)
        return new MonthlySalaryResponseDTO(
                totalSalary,
                actualSalary,
                dto.getTotalWorkingDays(),
                dto.getTotalDays()
        );
    }
}
