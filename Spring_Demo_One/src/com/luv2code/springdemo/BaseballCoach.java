package com.luv2code.springdemo;

public class BaseballCoach implements Coach
{

	// define a private field for dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyworkout()
	{
		return "spend 30 minutes on batting practise";
	}

	//use a fortuneservice to get fortune 
	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return "Just go:"+fortuneService.getFortune();
	}

	
}
