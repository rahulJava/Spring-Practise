package com.luv2code.springboot.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernotFoundException extends RuntimeException {

	
	public UsernotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	
}
