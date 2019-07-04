package com.luv2code.springboot.restfulwebservices;

public class HelloWorldBean 
{
	private String message;

	public HelloWorldBean(String message) {
		this.message=message;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		System.out.println("Inside get method");
		return message;
	}

	public void setMessage(String message) {
		System.out.println("Inside set method");
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}


	

}
