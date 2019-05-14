package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// creating a spring container
		
		//load spring configuration files
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve from spring container
		Coach theCoach = context.getBean("myBaseballCoach",Coach.class); 
		// call methods on the bean
		System.out.println("from Spring:"+theCoach.getDailyworkout());
		System.out.println(theCoach.getDailyFortunes());
		// close the context
		context.close();
		
		

	}

}
