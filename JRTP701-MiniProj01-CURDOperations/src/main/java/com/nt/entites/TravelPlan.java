package com.nt.entites;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="JRTP701_TRAVEL_PLAN")
public class TravelPlan {
	
	@Id
	@Column(name="PLAN_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer planId;
	
	@Column(name = "PLAN_NAME", length = 30)
	private String planName;
	
	@Column(name="PLAN_MIN_BUDGET")
	private Double planMinBudget;
	
	@Column(name="PLAN_DESCRIPTION", length = 50)
	private String planDescription;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	@Column(name="UPDATED_DATE", updatable = true, insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	@Column(name="CREATED_BY", length = 20)
	private String createdBy;
	@Column(name = "UPDATED_BY", length = 20)
	private String updatedBy;
	
	@Column(name="ACTIVE_SW", length=20)
	private String activeSW="active";
	
	

}
