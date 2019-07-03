package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}
     public TrackCoach() {
		
	}

	@Override
	public String getDailyworkout() {
		// TODO Auto-generated method stub
		return "get daily workout if you want to be fit";
	}

	@Override
	public String getDailyFortunes() {
		// TODO Auto-generated method stub
		return "Just Do It:"+fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff()
	{
		System.out.println("TrackCoach inside init method");
	}
	// add an destroy method
	public void doCleanupStuff()
	{
		System.out.println("TrackMyCoach inside destroy method");
	}

}
