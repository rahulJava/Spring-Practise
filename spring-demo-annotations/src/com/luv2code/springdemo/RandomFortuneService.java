package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	private String[] data = {
			"Beware of wolf",
			"This is your freind",
			"This is your buddy"
	};
	private Random ran= new Random();
	@Override
	public String getFortune() {
		int index = ran.nextInt(data.length);
		String theFortune = data[index];
		// TODO Auto-generated method stub
		return theFortune;
	}

	

}
