package com.vbz.hrms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salary_percentage")
public class SalaryPercentageMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double basicPercent;          
    private Double hraPercent;            
    private Double pfPercent;             

    private Double conveyancePercent;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBasicPercent() {
		return basicPercent;
	}

	public void setBasicPercent(Double basicPercent) {
		this.basicPercent = basicPercent;
	}

	public Double getHraPercent() {
		return hraPercent;
	}

	public void setHraPercent(Double hraPercent) {
		this.hraPercent = hraPercent;
	}

	public Double getPfPercent() {
		return pfPercent;
	}

	public void setPfPercent(Double pfPercent) {
		this.pfPercent = pfPercent;
	}

	public Double getConveyancePercent() {
		return conveyancePercent;
	}

	public void setConveyancePercent(Double conveyancePercent) {
		this.conveyancePercent = conveyancePercent;
	}

}
