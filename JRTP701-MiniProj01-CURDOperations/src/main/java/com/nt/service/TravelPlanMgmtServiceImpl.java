package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.config.AppConfigProperties;
import com.nt.constants.TravelPlanConstants;
import com.nt.entites.PlanCategory;
import com.nt.entites.TravelPlan;
import com.nt.repository.IPlanCategoryRepo;
import com.nt.repository.ITravelPlanRepo;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {

	@Autowired
	private ITravelPlanRepo travelPlanRepo;
	
	@Autowired
	private IPlanCategoryRepo planCategoryRepo;
	
	private Map<String, String> messages;
	
	@Autowired
	public TravelPlanMgmtServiceImpl(AppConfigProperties props) {
		messages = props.getMessages();
		System.out.println("Messages::"+messages);
	}
	

	@Override
	public String registerTravelPlan(TravelPlan plan) {
		//save the object
		TravelPlan saved = travelPlanRepo.save(plan);
		/*if(saved.getPlanId()!=null)
			return "TravelPlan is saved with the id value:"+saved.getPlanId();
		else
			return "Problem in saving the TravelPlan";*/
		
//		return saved.getPlanId()!=null?"TravelPlan is saved with the id value:"+saved.getPlanId():"Problem in saving the TravelPlan";
		return saved.getPlanId()!=null?messages.get(TravelPlanConstants.SAVE_SUCCESS)+saved.getPlanId():messages.get(TravelPlanConstants.SAVE_FAILURE);
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		// get all TravelPlan Categories
		List<PlanCategory> list = planCategoryRepo.findAll();
		Map<Integer, String> categoriesMap = new HashMap<Integer, String>();
		list.forEach(category->{
			categoriesMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlans() {
		// get all
		return travelPlanRepo.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		return travelPlanRepo.findById(planId).orElseThrow(()->new IllegalArgumentException(messages.get(TravelPlanConstants.FIND_BY_ID_FAILURE)));
		/*Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if(opt.isPresent())
			return opt.get();
		else {
			throw new IllegalArgumentException("plan id not found");
		}*/
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		//update the object
		Optional<TravelPlan> opt = travelPlanRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			travelPlanRepo.save(plan);
			return plan.getPlanId()+messages.get(TravelPlanConstants.UPDATE_SUCCESS);
		}else {
			return plan.getPlanId()+messages.get(TravelPlanConstants.UPDATE_FAILURE);
		}
		/*
		 * TravelPlan updated = travelPlanRepo.save(plan); return
		 * updated.getPlanId()+"Travel Plan is updated";
		 */
	}

	@Override
	public String deleteTravelPlanById(Integer planId) {
		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			travelPlanRepo.deleteById(planId);
			return planId+messages.get(TravelPlanConstants.DELETE_SUCCESS);
		}else {
			return planId+messages.get(TravelPlanConstants.DELETE_FAILURE);
		}
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			TravelPlan travelPlan = opt.get();
			travelPlan.setActiveSW(status);
			travelPlanRepo.save(travelPlan);
			return planId+messages.get(TravelPlanConstants.STATUS_CHANGE_SUCCESS);
		}
		return planId+messages.get(TravelPlanConstants.STATUS_CHANGE_FAILURE);
	}

}
