package com.vbz.hrms.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbz.hrms.Respositoy.MonthlySalaryRepository;
import com.vbz.hrms.Respositoy.SalaryDetailsRespo;
import com.vbz.hrms.Respositoy.UserResp;
import com.vbz.hrms.dto.MonthlySalaryRequestDTO;
import com.vbz.hrms.dto.MonthlySalaryResponseDTO;
import com.vbz.hrms.model.MonthlySalary;
import com.vbz.hrms.model.SalaryDetails;
import com.vbz.hrms.model.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Service
@Transactional
public class MonthlySalaryServiceImpl implements MonthlySalaryService {

    private final UserResp userRepo;
    private final SalaryDetailsRespo salaryRepo;
    private final MonthlySalaryRepository monthlyRepo;

    public MonthlySalaryServiceImpl(UserResp userRepo,
                                   SalaryDetailsRespo salaryRepo,
                                   MonthlySalaryRepository monthlyRepo) {
        this.userRepo = userRepo;
        this.salaryRepo = salaryRepo;
        this.monthlyRepo = monthlyRepo;
    }


    public String generateMonthlySalary(MonthlySalaryRequestDTO dto, HttpSession session) {

        Long userId = (Long) session.getAttribute("LOGGED_IN_USER_ID");
        if (userId == null) throw new IllegalStateException("HR not logged in");
        
        String role = (String) session.getAttribute("LOGGED_IN_ROLE");
        if (!role.equalsIgnoreCase("HR")) {
            throw new RuntimeException("Access denied. Only HR can generate salary");
        }
        
        if (userId == null || role == null) {
            throw new RuntimeException("Session expired. Please login again.");
        }
        
        User hr = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("HR not found"));

        User employee = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        if (monthlyRepo.existsByUserAndMonthAndYear(employee, dto.getMonth(), dto.getYear())) {
            throw new IllegalStateException("Salary already generated for this month");
        }

        SalaryDetails salary = salaryRepo.findByUser(employee)
                .orElseThrow(() -> new RuntimeException("Salary details not set"));

        // Yearly → Monthly
        BigDecimal basicPerMonth = salary.getBasic().divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
        BigDecimal hraPerMonth = salary.getHra().divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
        BigDecimal convPerMonth = salary.getConveyanceAllowance().divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);

        // Per day
        BigDecimal totalDays = BigDecimal.valueOf(dto.getTotalDays());
        BigDecimal workedDays =BigDecimal.valueOf(dto.getActualWorkingDays());

        BigDecimal basicPay = basicPerMonth.divide(totalDays, 2, RoundingMode.HALF_UP).multiply(workedDays);
        BigDecimal hraPay = hraPerMonth.divide(totalDays, 2, RoundingMode.HALF_UP).multiply(workedDays);
        BigDecimal convPay = convPerMonth.divide(totalDays, 2, RoundingMode.HALF_UP).multiply(workedDays);

        BigDecimal totalSalary = basicPay.add(hraPay).add(convPay).setScale(2, RoundingMode.HALF_UP);

        MonthlySalary ms = new MonthlySalary();
        ms.setUser(employee);
        ms.setGeneratedBy(hr);
        ms.setMonth(dto.getMonth());
        ms.setYear(dto.getYear());
        ms.setTotalDays(dto.getTotalDays());
        ms.setActualWorkingDays(dto.getActualWorkingDays());
        ms.setBasic(basicPay);
        ms.setHra(hraPay);
        ms.setConveyanceAllowance(convPay);
        ms.setTotalSalary(totalSalary);

        monthlyRepo.save(ms);

        return "Monthly salary generated successfully";
    }

    @Override
    public List<MonthlySalaryResponseDTO> getSalaryByMonthYear(Integer year, Integer month) {
        return monthlyRepo.findByMonthAndYear(month, year).stream().map(this::map).toList();
    }

    @Override
    public List<MonthlySalaryResponseDTO> mySalary(HttpSession session) {

        Long userId = (Long) session.getAttribute("LOGGED_IN_USER_ID");

        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return monthlyRepo.findByUser(user)
                .stream()
                .map(this::map)
                .toList();
    }

    private MonthlySalaryResponseDTO map(MonthlySalary s) {
        MonthlySalaryResponseDTO dto = new MonthlySalaryResponseDTO();
        dto.setId(s.getId());
        dto.setEmployeeId(s.getUser().getId());
        dto.setEmployeeName(s.getUser().getUsername());
        dto.setGeneratedById(s.getGeneratedBy().getId());
        dto.setGeneratedByName(s.getGeneratedBy().getUsername());
        dto.setTotalDays(s.getTotalDays());
        dto.setActualWorkingDays(s.getActualWorkingDays());
        dto.setBasic(s.getBasic());
        dto.setHra(s.getHra());
        dto.setConveyanceAllowance(s.getConveyanceAllowance());
        dto.setTotalSalary(s.getTotalSalary());
        dto.setMonth(s.getMonth());
        dto.setYear(s.getYear());
        return dto;
    }
}
