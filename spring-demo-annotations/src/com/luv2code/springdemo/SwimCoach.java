package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String Team;
	
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return Team;
	}
	public SwimCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Swom 1000mtrs as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
