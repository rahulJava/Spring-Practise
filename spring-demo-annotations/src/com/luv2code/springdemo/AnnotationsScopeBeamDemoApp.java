package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsScopeBeamDemoApp 
{
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach theCoach1 = context.getBean("tennisCoach",Coach.class);
		boolean result=(theCoach==theCoach1);
		System.out.println("result:"+result);
		System.out.println(theCoach.getDailyWorkOut());
		
		context.close();
	}

}
