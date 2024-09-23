package com.rewardpoint.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.rewardpoint.model.Transaction;
import  com.rewardpoint.service.CalculateRewardPointService;


@RestController
@RequestMapping("/api/reward-points")
public class RewardPointCalculator {

	@Autowired
	private CalculateRewardPointService rewardpointcalculatorservice;
	
	@PostMapping
	public Map<String ,Integer> calculateRewardPoints(@RequestBody List<Transaction> transactions)
	{
		
		return rewardpointcalculatorservice.CalculateTotalpoint(transactions);
	}
	
}