package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) 
	{
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext2.xml");
		
		//retrieve bean from spring container 
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		//check if they are the same
		boolean result =(theCoach==alphaCoach);
		System.out.println("if the singletone is true:"+result);
		System.out.println("memory location:"+theCoach);
		System.out.println("memory loacation:"+alphaCoach);
		
		
	}

}
