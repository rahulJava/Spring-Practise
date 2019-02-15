package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TennisCoach theCoach = context.getBean("tennisCoach",TennisCoach.class);
		Coach thecoach1 = context.getBean("cricketCoach",Coach.class);
		Coach usingFieldInjection = context.getBean("chessCoach",Coach.class);
		
		
		System.out.println(usingFieldInjection.getDailyWorkOut());
		System.out.println(usingFieldInjection.getDailyFortune());
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getTeam());
		System.out.println(theCoach.getEmailAddress());
		context.close();

	}

}
