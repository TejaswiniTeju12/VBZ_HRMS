package com.vbz.hrms.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "monthly_salary", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","month","year"}))
public class MonthlySalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Full monthly salary (Basic + HRA + Conveyance)
    private BigDecimal basic;
    private BigDecimal hra;
    private BigDecimal conveyanceAllowance;
    
    private BigDecimal totalSalary;
    private BigDecimal actualSalary;
    
    private Integer actualWorkingDays; 
    private Integer totalDays; 
    
    private Integer month;
    private Integer year;
    
    private LocalDateTime calculatedOn;
    private LocalDateTime updatedOn;
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(BigDecimal totalSalary) {
		this.totalSalary = totalSalary;
	}

	public BigDecimal getActualSalary() {
		return actualSalary;
	}

	public void setActualSalary(BigDecimal actualSalary) {
		this.actualSalary = actualSalary;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
    public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}


	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
	public LocalDateTime getCalculatedOn() {
		return calculatedOn;
	}

	public void setCalculatedOn(LocalDateTime calculatedOn) {
		this.calculatedOn = calculatedOn;
	}


	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	
	 @PrePersist
	    public void onCreate() {
	        this.setCalculatedOn(LocalDateTime.now());
	    }
	 
	 @PreUpdate
	    public void onUpdate() {
	        this.setCalculatedOn(LocalDateTime.now());
	    }

	public Integer getActualWorkingDays() {
		return actualWorkingDays;
	}

	public void setActualWorkingDays(Integer actualWorkingDays) {
		this.actualWorkingDays = actualWorkingDays;
	}


	public Integer getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}


	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "generated_by", nullable = false)
	    private User generatedBy;

	 public User getGeneratedBy() {
		    return generatedBy;
		}

		public void setGeneratedBy(User generatedBy) {
		    this.generatedBy = generatedBy;
		}





   
}
