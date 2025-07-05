package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CourseDetails;

public interface ICourseDetailsRepository extends JpaRepository<CourseDetails, Integer> {

}
