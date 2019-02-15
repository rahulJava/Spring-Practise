package com.luv2code.springdemo;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	
	private String emailAddress;
	private String Team;
		
	

	public void setEmailAddress(String emailAddress) {
		System.out.println("cricket coach inside setEmailAddress");
		this.emailAddress = emailAddress;
		System.out.println("hi");
	}

	public void setTeam(String team) {
		System.out.println("cricket coach inside setTeam");
		this.Team = team;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return Team;
	}

	public CricketCoach()
	{
		System.out.println("I am inside in the constructor of cricket");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Hey i am inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		return "practise fast bowling for 15 minutes a day";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
