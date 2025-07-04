package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entites.PlanCategory;

public interface IPlanCategoryRepo extends JpaRepository<PlanCategory, Integer>{

}
