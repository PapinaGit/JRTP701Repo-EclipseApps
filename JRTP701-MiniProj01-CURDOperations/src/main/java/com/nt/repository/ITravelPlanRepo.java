package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entites.TravelPlan;

public interface ITravelPlanRepo extends JpaRepository<TravelPlan, Integer>{

}
