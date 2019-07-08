package com.luv2code.springboot.restfulwebservices.user;

import java.util.Date;

public class User 
{
	private Integer ID;
	private String name;
	private Date birthDate;
	public Integer getID() {
		return ID;
	}
	public User(Integer iD, String name, Date birthDate) {
		
		super();
		System.out.println("Inside constructor arguement");
		ID = iD;
		this.name = name;
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		
		return "User [ID=" + ID + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		System.out.println("Inside getter");
		return name;
	}
	public void setName(String name) {
		System.out.println("Inside setter");
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
