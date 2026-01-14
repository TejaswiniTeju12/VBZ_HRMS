package com.vbz.hrms.service;

import org.springframework.stereotype.Service;

import com.vbz.hrms.Respositoy.*;
import com.vbz.hrms.dto.OnboardingRequestDTO;
import com.vbz.hrms.model.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OnboardingServiceImpl implements OnboardingService {

    private final UserResp userResp;
    private final PersonalDetailsRespo personalDetailsRespo;
    private final BankDetailsRespo bankDetailsRespo;
    private final EmployeeStatutoryDetailsRespo employeeStatutoryDetailsRespo;
    private final JobDetailsRespo jobDetailsRespo;
    private final DepartmentRespo departmentRespo;
    private final DesignationRespo designationRespo;
    private final SalaryDetailsRespo salaryDetailsRespo;

    public OnboardingServiceImpl(UserResp userResp,
                                 PersonalDetailsRespo personalDetailsRespo,
                                 BankDetailsRespo bankDetailsRespo,
                                 EmployeeStatutoryDetailsRespo employeeStatutoryDetailsRespo,
                                 JobDetailsRespo jobDetailsRespo,
                                 DepartmentRespo departmentRespo,
                                 DesignationRespo designationRespo,
                                 SalaryDetailsRespo salaryDetailsRespo) {

        this.userResp = userResp;
        this.personalDetailsRespo = personalDetailsRespo;
        this.bankDetailsRespo = bankDetailsRespo;
        this.employeeStatutoryDetailsRespo = employeeStatutoryDetailsRespo;
        this.jobDetailsRespo = jobDetailsRespo;
        this.departmentRespo = departmentRespo;
        this.designationRespo = designationRespo;
        this.salaryDetailsRespo = salaryDetailsRespo;
    }

    @Override
    public String empOnBoarding(OnboardingRequestDTO dto) {

        User user = userResp.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Personal Details
        PersonalDetails p = new PersonalDetails();
        p.setFirstName(dto.getPersonalDetailsDTO().getFirstName());
        p.setLastName(dto.getPersonalDetailsDTO().getLastName());
        p.setGender(dto.getPersonalDetailsDTO().getGender());
        p.setDob(dto.getPersonalDetailsDTO().getDob());
        p.setNationality(dto.getPersonalDetailsDTO().getNationality());
        p.setMaritalStatus(dto.getPersonalDetailsDTO().getMaritalStatus());
        p.setBloodGroup(dto.getPersonalDetailsDTO().getBloodGroup());
        p.setAadhaarNumber(dto.getPersonalDetailsDTO().getAadhaarNumber());
        p.setPanNumber(dto.getPersonalDetailsDTO().getPanNumber());
        p.setPhoneNumber(dto.getPersonalDetailsDTO().getPhoneNumber());
        p.setEmailId(dto.getPersonalDetailsDTO().getEmailId());
        p.setAddress1(dto.getPersonalDetailsDTO().getAddress1());
        p.setAddress2(dto.getPersonalDetailsDTO().getAddress2());
        p.setEmergencyContactName(dto.getPersonalDetailsDTO().getEmergencyContactName());
        p.setEmergencyPhoneNumber(dto.getPersonalDetailsDTO().getEmergencyPhoneNumber());
        p.setUser(user);
        personalDetailsRespo.save(p);

        // Bank
        BankDetails b = new BankDetails();
        b.setBankName(dto.getBankDetailsDTO().getBankName());
        b.setAccountNumber(dto.getBankDetailsDTO().getAccountNumber());
        b.setIfsc(dto.getBankDetailsDTO().getIfsc());
        b.setUser(user);
        bankDetailsRespo.save(b);

        // Statutory
        EmployeeStatutoryDetails e = new EmployeeStatutoryDetails();
        e.setEsi(dto.getEmployeeStatutoryDetailsDTO().getEsi());
        e.setMin(dto.getEmployeeStatutoryDetailsDTO().getMin());
        e.setPfUan(dto.getEmployeeStatutoryDetailsDTO().getPfUan());
        e.setUser(user);
        employeeStatutoryDetailsRespo.save(e);

        // Job Details (ID based)
        JobDetails j = new JobDetails();
        j.setDateOfJoining(dto.getJobDetailsDTO().getDateOfJoining());
        j.setWorkLocation(dto.getJobDetailsDTO().getWorkLocation());
        j.setUser(user);

        Department dept = departmentRespo.findById(
                dto.getJobDetailsDTO().getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Designation desig = designationRespo.findById(
                dto.getJobDetailsDTO().getDesignationId())
                .orElseThrow(() -> new RuntimeException("Designation not found"));

        j.setDepartment(dept);
        j.setDesignation(desig);
        jobDetailsRespo.save(j);

        // Salary
        SalaryDetails s = new SalaryDetails();
        s.setBasic(dto.getSalaryDetailsDTO().getBasic());
        s.setConveyanceAllowance(dto.getSalaryDetailsDTO().getConveyanceAllowance());
        s.setCtc(dto.getSalaryDetailsDTO().getCtc());
        s.setHra(dto.getSalaryDetailsDTO().getHra());
        s.setUser(user);
        salaryDetailsRespo.save(s);

        return "Onboarding successful";
    }
}
