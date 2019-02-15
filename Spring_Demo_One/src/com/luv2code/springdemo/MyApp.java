package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Coach theCoach = new BaseballCoach();
		Coach theCoach1 = new TrackCoach();
		//System.out.println("::"+theCoach.getDailyworkout());
		System.out.println("::"+theCoach1.getDailyworkout());

	}

}
