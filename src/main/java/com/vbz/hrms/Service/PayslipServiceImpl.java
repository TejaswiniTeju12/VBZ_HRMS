package com.vbz.hrms.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.vbz.hrms.Respositoy.BankDetailsRespo;
import com.vbz.hrms.Respositoy.EmployeeStatutoryDetailsRespo;
import com.vbz.hrms.Respositoy.MonthlySalaryRepository;
import com.vbz.hrms.Respositoy.PersonalDetailsRespo;
import com.vbz.hrms.Respositoy.UserResp;
import com.vbz.hrms.dto.PaySlipResponseDTO;
import com.vbz.hrms.model.BankDetails;
import com.vbz.hrms.model.EmployeeStatutoryDetails;
import com.vbz.hrms.model.MonthlySalary;
import com.vbz.hrms.model.PersonalDetails;
import com.vbz.hrms.model.User;

@Service
public class PayslipServiceImpl {

    private final UserResp userRepo;
    private final PersonalDetailsRespo personalRepo;
    private final BankDetailsRespo bankRepo;
    private final EmployeeStatutoryDetailsRespo statutoryRepo;
    private final MonthlySalaryRepository monthlyRepo;

    public PayslipServiceImpl(
            UserResp userRepo,
            PersonalDetailsRespo personalRepo,
            BankDetailsRespo bankRepo,
            EmployeeStatutoryDetailsRespo statutoryRepo,
            MonthlySalaryRepository monthlyRepo) {

        this.userRepo = userRepo;
        this.personalRepo = personalRepo;
        this.bankRepo = bankRepo;
        this.statutoryRepo = statutoryRepo;
        this.monthlyRepo = monthlyRepo;
    }

    public PaySlipResponseDTO getPayslip(Long userId, Integer month, Integer year) {

        if (userId == null) {
            throw new RuntimeException("User not logged in");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PersonalDetails personal = personalRepo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Personal details not found"));

        BankDetails bank = bankRepo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Bank details not found"));

        EmployeeStatutoryDetails statutory = statutoryRepo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Statutory details not found"));

        MonthlySalary salary = monthlyRepo
                .findByUserAndMonthAndYear(user, month, year)
                .orElseThrow(() -> new RuntimeException("Salary not generated"));

        PaySlipResponseDTO dto = new PaySlipResponseDTO();

        dto.setName(personal.getFirstName() + " " + personal.getLastName());
        dto.setDepartment(
                user.getDepartment() != null
                        ? user.getDepartment().getDepartmentName()
                        : "NA");
        dto.setDesignation(
                user.getDesignation() != null
                        ? user.getDesignation().getDesignationName()
                        : "NA");
        dto.setLocation(personal.getAddress1()); 
        dto.setDateOfJoining(user.getCreatedOn().toLocalDate());

        dto.setBankName(bank.getBankName());
        dto.setAccountNumber(bank.getAccountNumber());
        dto.setPfNo(statutory.getPfUan());
        dto.setEsiNo(statutory.getEsi());
       
        dto.setMonth(month);
        dto.setYear(year);
        dto.setTotalDays(salary.getTotalDays());
        dto.setWorkedDays(salary.getActualWorkingDays());

        dto.setBasic(salary.getBasic());
        dto.setHra(salary.getHra());
        dto.setConveyance(salary.getConveyanceAllowance());

        BigDecimal pf = salary.getPf() != null ? salary.getPf() : BigDecimal.ZERO;
        dto.setPf(pf);

        BigDecimal totalEarnings =
                salary.getBasic()
                        .add(salary.getHra())
                        .add(salary.getConveyanceAllowance());

        dto.setTotalEarnings(totalEarnings);
        dto.setTotalDeductions(pf);
        dto.setNetPay(totalEarnings.subtract(pf));

        return dto;
    }
}
