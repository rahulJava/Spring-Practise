package com.luv2code.springdemo;

public class BaseballCoach implements Coach
{

	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyworkout()
	{
		return "getDailyWorkout";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	
}
