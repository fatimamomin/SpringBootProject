package com.rewardpoint.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import  com.rewardpoint.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class CalculateRewardPointService {

	public int calculatePoints(int amount)
	{
		int points=0;
		if(amount >100)
		{ System.out.println("amount first if:"+amount);
			points+=(amount -100)*2;
		amount=100;
		}
		 if(amount>=50)
		{System.out.println("second if amount if:"+amount);
			points+=(amount-50)*1;
		}
		return points;
	}
	
	public Map<String,Integer>CalculateTotalpoint(List <Transaction> transactions)
	{
		Map<String, Integer> totalPoints= new HashMap<>();
		for(Transaction transaction: transactions) {
			int points=calculatePoints(transaction.getAmount());
			System.out.println("points:"+points);
			totalPoints.put(transaction.getCustomer(), totalPoints.getOrDefault(transaction.getCustomer(),0)+points);
			
			}
		
		return totalPoints;
	}
}
