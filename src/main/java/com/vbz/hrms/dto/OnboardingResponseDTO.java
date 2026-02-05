package com.vbz.hrms.dto;

public class OnboardingResponseDTO {

    private Long userId;

    private PersonalDetailsDTO personalDetails;
    private BankDetailsDTO bankDetails;
    private EmployeeStatutoryDetailsDTO statutoryDetails;
    private JobDetailsDTO jobDetails;
    private SalaryDetailsDTO salaryDetails;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public PersonalDetailsDTO getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetailsDTO personalDetails) {
		this.personalDetails = personalDetails;
	}
	public BankDetailsDTO getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetailsDTO bankDetails) {
		this.bankDetails = bankDetails;
	}
	public EmployeeStatutoryDetailsDTO getStatutoryDetails() {
		return statutoryDetails;
	}
	public void setStatutoryDetails(EmployeeStatutoryDetailsDTO statutoryDetails) {
		this.statutoryDetails = statutoryDetails;
	}
	public JobDetailsDTO getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(JobDetailsDTO jobDetails) {
		this.jobDetails = jobDetails;
	}
	public SalaryDetailsDTO getSalaryDetails() {
		return salaryDetails;
	}
	public void setSalaryDetails(SalaryDetailsDTO salaryDetails) {
		this.salaryDetails = salaryDetails;
	}
}
