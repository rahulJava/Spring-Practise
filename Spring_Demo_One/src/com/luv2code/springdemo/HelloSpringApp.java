package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// creating a spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("myCoach",Coach.class); 
		System.out.println("from Spring:"+theCoach.getDailyworkout());
		System.out.println(theCoach.getDailyFortunes());
		context.close();
		
		

	}

}
