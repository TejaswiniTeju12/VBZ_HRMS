package com.vbz.hrms.model;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "MonthlySalary")
public class MonthlySalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal ctc;
    private BigDecimal basic;
    private BigDecimal hra;
    private BigDecimal conveyanceAllowance;
    private BigDecimal TotalSalary;
    private BigDecimal ActualSalary;
    private Integer totalWorkingDays;
    private Integer totalDays;
   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCtc() {
		return ctc;
	}

	public void setCtc(BigDecimal ctc) {
		this.ctc = ctc;
	}

	public BigDecimal getBasic() {
		return basic;
	}

	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	public BigDecimal getHra() {
		return hra;
	}

	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}

	public BigDecimal getConveyanceAllowance() {
		return conveyanceAllowance;
	}

	public void setConveyanceAllowance(BigDecimal conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}

	public BigDecimal getTotalSalary() {
		return TotalSalary;
	}

	public void setTotalSalary(BigDecimal totalSalary) {
		TotalSalary = totalSalary;
	}

	public BigDecimal getActualSalary() {
		return ActualSalary;
	}

	public void setActualSalary(BigDecimal actualSalary) {
		ActualSalary = actualSalary;
	}

	public Integer getTotalWorkingDays() {
		return totalWorkingDays;
	}

	public void setTotalWorkingDays(Integer totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    
}
