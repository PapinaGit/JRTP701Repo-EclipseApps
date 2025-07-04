package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entites.TravelPlan;

public interface ITravelPlanMgmtService {

	//save operation
	public String registerTravelPlan(TravelPlan plan); 
	//for select operation
	public Map<Integer, String> getTravelPlanCategories();  
	//for select operation
	public List<TravelPlan> showAllTravelPlans(); 
	//for edit operation(To show the existing record for editing)
	public TravelPlan showTravelPlanById(Integer planId); 
	//for edit operation form submission
	public String updateTravelPlan(TravelPlan plan); 
	//for deletion operation (hard deletion)
	public String deleteTravelPlanById(Integer planId);
	//for soft deletion activity
	public String changeTravelPlanStatus(Integer planId, String status);
	
}
