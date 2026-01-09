package com.vbz.hrms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "leaves")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
     
	private String leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	private Long days;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public LocalDateTime getDeletedOn() {
		return deletedOn;
	}
	public void setDeletedOn(LocalDateTime deletedOn) {
		this.deletedOn = deletedOn;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private String reason;
	
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private LocalDateTime deletedOn;
	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@PrePersist
	private void onCreated() {
		this.createdOn=LocalDateTime.now();
		this.updatedOn=LocalDateTime.now();
		this.leaveStatus=LeaveStatus.PENDING;
	}
	 @PreUpdate
	    public void onUpdate() {
	        this.updatedOn = LocalDateTime.now();
	    }

	    public void markDeleted() {
	        this.deletedOn = LocalDateTime.now();
	    }
}
