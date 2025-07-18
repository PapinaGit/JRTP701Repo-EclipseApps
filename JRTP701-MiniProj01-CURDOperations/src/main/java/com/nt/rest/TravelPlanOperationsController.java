package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entites.TravelPlan;
import com.nt.service.ITravelPlanMgmtService;

@RestController
@RequestMapping("/travelplan/api") // Global path(optional)
public class TravelPlanOperationsController {

	@Autowired
	private ITravelPlanMgmtService planService;

	@GetMapping("/categories")
	public ResponseEntity<?> showTravelPlanCategories() {
		// invoke service class methods
		try {
			Map<Integer, String> mapCategories = planService.getTravelPlanCategories();
			return new ResponseEntity<Map<Integer, String>>(mapCategories, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<String> saveTravelPlan(@RequestBody TravelPlan plan) {
		// use service
		try {
			String msg = planService.registerTravelPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTravelPlans() {
		// use service
		try {
			List<TravelPlan> allTravelPlans = planService.showAllTravelPlans();
			return new ResponseEntity<List<TravelPlan>>(allTravelPlans, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{planId}")
	public ResponseEntity<?> getTravelPlanById(@PathVariable Integer planId) {
		// use service
		try {
			TravelPlan plan = planService.showTravelPlanById(planId);
			return new ResponseEntity<TravelPlan>(plan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateTravelPlan(@RequestBody TravelPlan plan) {
		// use service
		try {
			String msg = planService.updateTravelPlan(plan);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{planId}")
	public ResponseEntity<?> removeTravelPlanById(@PathVariable Integer planId) {
		// user service
		try {
			String msg = planService.deleteTravelPlanById(planId);
			return new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<?> changeTravelPlanStatus(@PathVariable Integer planId, @PathVariable String status) {
		// use service
		try {
			String msg = planService.changeTravelPlanStatus(planId, status);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
