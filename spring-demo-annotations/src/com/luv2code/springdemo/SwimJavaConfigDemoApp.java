package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig2.class);
		
		SwimCoach thecoach1 = context.getBean("swimCoach",SwimCoach.class);
		
		
		System.out.println(thecoach1.getDailyWorkOut());
		System.out.println(thecoach1.getDailyFortune());
		System.out.println(thecoach1.getEmail());
		System.out.println(thecoach1.getTeam());
	
		context.close();

	}

}
	