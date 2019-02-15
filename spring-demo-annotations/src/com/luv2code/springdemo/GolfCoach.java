package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public GolfCoach()
	{System.out.println("Inside default constructor of golf coach");
		
	}
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method of golf coach");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
