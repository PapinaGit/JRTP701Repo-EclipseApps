package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="JRTP_COURSE_DETAILS")
public class CourseDetails {

	@Id
	@GeneratedValue
	private Integer courseId;
	@Column(length = 30)
	private String courseName;
	@Column(length = 30)
	private String location;
	@Column(length = 30)
	private String courseCategory;
	@Column(length = 30)
	private String facultyName;
	private Double fee;
	@Column(length = 30)
	private String adminName;
	private Long adminContact;
	@Column(length = 30)
	private String trainingMode;
	private LocalDateTime startDate;
	@Column(length = 30)
	private String courseStatus;
	@CreationTimestamp
	@Column(updatable = false, insertable = true)
	private LocalDateTime creationDate;
	@UpdateTimestamp
	@Column(updatable = true, insertable = false)
	private LocalDateTime updationDate;
	@Column(length = 30)
	private String createdBy;
	@Column(length = 30)
	private String updatedBy;
}
