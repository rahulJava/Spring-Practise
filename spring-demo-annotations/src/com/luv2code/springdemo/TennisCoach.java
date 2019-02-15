package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
       
	  
	@Value("${foo.email}")
	private String emailAddress;
	@Value("${foo.team}")
	private String Team;
	   private FortuneService fortuneService;
	   
	   //Spring will scan the package and look for the class who has implemented the FortuneService interface and ten creates an instance of it 
	   // and will inject the instance of happyfortuneservice here
	   @Autowired
	   
	   public TennisCoach(@Qualifier("happyFortuneService") FortuneService thefortuneService)
	   {
		   fortuneService=thefortuneService;
	   }
	   //define my init method
	   @PostConstruct
	   public void domyStartupStuff()
	   {
		   System.out.println("Inside line no 36");
		   	System.out.println("Inside startup stuff");
	   }
	   @PreDestroy
	   public void doMycleanStuff()
	   {
		   System.out.println("inside do my clean stuff");
	   }
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "practise your back hand volley";
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}
	public String getTeam() {
		return Team;
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
