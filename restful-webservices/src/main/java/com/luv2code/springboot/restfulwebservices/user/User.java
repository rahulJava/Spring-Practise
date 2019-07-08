package com.luv2code.springboot.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User 
{
	//Customized exception
	private Integer ID;
	@Size(min=2,message="name should have atleast two characters")
	private String name;
	@Past(message="DOB can't be in future")
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
