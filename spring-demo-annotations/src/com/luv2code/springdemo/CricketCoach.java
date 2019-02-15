package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	public CricketCoach()
	{
		
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeStuff(FortuneService thefortuneService)
	
	{
		fortuneService=thefortuneService;
		
	}
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "practise on a daily basis";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
