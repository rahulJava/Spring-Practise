package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student 
{
	private String firstName;
	private String lastName;
	private String Country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public Student()
	{
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE","Germany");
		countryOptions.put("IN","India");
		countryOptions.put("US","United States of America");
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
