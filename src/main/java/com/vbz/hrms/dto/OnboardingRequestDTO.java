package com.vbz.hrms.dto;

import lombok.Data;

@Data
public class OnboardingRequestDTO  {
	
	private Long userId;
    private PersonalDetailsDTO personalDetailsDTO ;
    private JobDetailsDTO jobDetailsDTO;
    private SalaryDetailsDTO salaryDetailsDTO;
    private BankDetailsDTO bankDetailsDTO;
    private EmployeeStatutoryDetailsDTO employeeStatutoryDetailsDTO;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public PersonalDetailsDTO getPersonalDetailsDTO() {
		return personalDetailsDTO;
	}
	public void setPersonalDetailsDTO(PersonalDetailsDTO personalDetailsDTO) {
		this.personalDetailsDTO = personalDetailsDTO;
	}
	public JobDetailsDTO getJobDetailsDTO() {
		return jobDetailsDTO;
	}
	public void setJobDetailsDTO(JobDetailsDTO jobDetailsDTO) {
		this.jobDetailsDTO = jobDetailsDTO;
	}
	public SalaryDetailsDTO getSalaryDetailsDTO() {
		return salaryDetailsDTO;
	}
	public void setSalaryDetailsDTO(SalaryDetailsDTO salaryDetailsDTO) {
		this.salaryDetailsDTO = salaryDetailsDTO;
	}
	public BankDetailsDTO getBankDetailsDTO() {
		return bankDetailsDTO;
	}
	public void setBankDetailsDTO(BankDetailsDTO bankDetailsDTO) {
		this.bankDetailsDTO = bankDetailsDTO;
	}
	public EmployeeStatutoryDetailsDTO getEmployeeStatutoryDetailsDTO() {
		return employeeStatutoryDetailsDTO;
	}
	public void setEmployeeStatutoryDetailsDTO(EmployeeStatutoryDetailsDTO employeeStatutoryDetailsDTO) {
		this.employeeStatutoryDetailsDTO = employeeStatutoryDetailsDTO;
	}

}
