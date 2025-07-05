package com.nt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.CourseDetails;

public interface ICourseDetailsRepository extends JpaRepository<CourseDetails, Integer> {

	@Query("SELECT DISTINCT(courseCategory) from CourseDetails")
	public Set<String> getUniqueCourseCategories();
	
	@Query("SELECT DISTINCT(facultyName) from CourseDetails")
	public Set<String> getUniqueFacultyNames();
	
	@Query("SELECT DISTINCT(trainingMode) from CourseDetails")
	public Set<String> getUniqueTrainingModes();
	
	
}
