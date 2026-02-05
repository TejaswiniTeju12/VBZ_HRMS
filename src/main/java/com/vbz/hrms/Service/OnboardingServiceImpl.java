package com.vbz.hrms.service;

import org.springframework.stereotype.Service;

import com.vbz.hrms.Respositoy.*;
import com.vbz.hrms.dto.*;
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

        //  Bank Details
        BankDetails b = new BankDetails();
        b.setBankName(dto.getBankDetailsDTO().getBankName());
        b.setAccountNumber(dto.getBankDetailsDTO().getAccountNumber());
        b.setIfsc(dto.getBankDetailsDTO().getIfsc());
        b.setUser(user);
        bankDetailsRespo.save(b);

        // Statutory Details
        EmployeeStatutoryDetails e = new EmployeeStatutoryDetails();
        e.setEsi(dto.getEmployeeStatutoryDetailsDTO().getEsi());
        e.setMin(dto.getEmployeeStatutoryDetailsDTO().getMin());
        e.setPfUan(dto.getEmployeeStatutoryDetailsDTO().getPfUan());
        e.setUser(user);
        employeeStatutoryDetailsRespo.save(e);

        // Job Details (USING NAMES)
        JobDetails j = new JobDetails();
        j.setDateOfJoining(dto.getJobDetailsDTO().getDateOfJoining());
        j.setWorkLocation(dto.getJobDetailsDTO().getWorkLocation());
        j.setUser(user);

        Department dept = departmentRespo
                .findByDepartmentName(dto.getJobDetailsDTO().getDepartmentName())
                .orElseThrow(() -> new RuntimeException("Invalid department name"));

        Designation desig = designationRespo
                .findByDesignationName(dto.getJobDetailsDTO().getDesignationName())
                .orElseThrow(() -> new RuntimeException("Invalid designation name"));

        j.setDepartment(dept);
        j.setDesignation(desig);
        jobDetailsRespo.save(j);

        // 5️⃣ Salary Details
        SalaryDetails s = new SalaryDetails();
        s.setBasic(dto.getSalaryDetailsDTO().getBasic());
        s.setHra(dto.getSalaryDetailsDTO().getHra());
        s.setConveyanceAllowance(dto.getSalaryDetailsDTO().getConveyanceAllowance());
        s.setCtc(dto.getSalaryDetailsDTO().getCtc());
        s.setUser(user);
        salaryDetailsRespo.save(s);

        return "Onboarding successful";
    }
   
    @Override
    public OnboardingResponseDTO getSelfProfile(Long userId) {

        User user = userResp.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PersonalDetails p = personalDetailsRespo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Personal details not found"));

        BankDetails b = bankDetailsRespo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Bank details not found"));

        EmployeeStatutoryDetails e = employeeStatutoryDetailsRespo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Statutory details not found"));

        JobDetails job = jobDetailsRespo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Job details not found"));

        SalaryDetails s = salaryDetailsRespo.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Salary details not found"));

        JobDetailsDTO jobDto = new JobDetailsDTO();
        jobDto.setDateOfJoining(job.getDateOfJoining());
        jobDto.setWorkLocation(job.getWorkLocation());
        jobDto.setDepartmentName(job.getDepartment().getDepartmentName());
        jobDto.setDesignationName(job.getDesignation().getDesignationName());

        OnboardingResponseDTO response = new OnboardingResponseDTO();
        response.setUserId(userId);
        response.setPersonalDetails(mapPersonal(p));
        response.setBankDetails(mapBank(b));
        response.setStatutoryDetails(mapStatutory(e));
        response.setJobDetails(jobDto);
        response.setSalaryDetails(mapSalary(s));

        return response;
    }

   
    private PersonalDetailsDTO mapPersonal(PersonalDetails p) {
        PersonalDetailsDTO dto = new PersonalDetailsDTO();
        dto.setFirstName(p.getFirstName());
        dto.setLastName(p.getLastName());
        dto.setGender(p.getGender());
        dto.setDob(p.getDob());
        dto.setNationality(p.getNationality());
        dto.setMaritalStatus(p.getMaritalStatus());
        dto.setBloodGroup(p.getBloodGroup());
        dto.setAadhaarNumber(p.getAadhaarNumber());
        dto.setPanNumber(p.getPanNumber());
        dto.setPhoneNumber(p.getPhoneNumber());
        dto.setEmailId(p.getEmailId());
        dto.setAddress1(p.getAddress1());
        dto.setAddress2(p.getAddress2());
        dto.setEmergencyContactName(p.getEmergencyContactName());
        dto.setEmergencyPhoneNumber(p.getEmergencyPhoneNumber());
        return dto;
    }

    private BankDetailsDTO mapBank(BankDetails b) {
        BankDetailsDTO dto = new BankDetailsDTO();
        dto.setBankName(b.getBankName());
        dto.setAccountNumber(b.getAccountNumber());
        dto.setIfsc(b.getIfsc());
        return dto;
    }

    private EmployeeStatutoryDetailsDTO mapStatutory(EmployeeStatutoryDetails e) {
        EmployeeStatutoryDetailsDTO dto = new EmployeeStatutoryDetailsDTO();
        dto.setEsi(e.getEsi());
        dto.setMin(e.getMin());
        dto.setPfUan(e.getPfUan());
        return dto;
    }

    private SalaryDetailsDTO mapSalary(SalaryDetails s) {
        SalaryDetailsDTO dto = new SalaryDetailsDTO();
        dto.setBasic(s.getBasic());
        dto.setHra(s.getHra());
        dto.setConveyanceAllowance(s.getConveyanceAllowance());
        dto.setCtc(s.getCtc());
        return dto;
    }
}
