package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ChessCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	public ChessCoach()
	{
		System.out.println("Inside default constructor of ChessCoach");
	}
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Play chess and be happy";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
