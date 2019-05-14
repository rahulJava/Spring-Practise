package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CricketCoach theCoach	 = context.getBean("myCricketCoach",CricketCoach.class);
		System.out.println(theCoach.getDailyworkout());
		System.out.println(theCoach.getDailyFortunes());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		context.close();
		
		
	}

}
