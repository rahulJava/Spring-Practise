package com.luv2code.springboot.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="All details about the user")
@Entity
public class User 
{
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Customized exception
	@Id
	@GeneratedValue
	private Integer ID;
	@Size(min=2,message="name should have atleast two characters")
	@ApiModelProperty("name should have atleast two characters")
	private String name;
	@Past(message="DOB can't be in future")
	@ApiModelProperty("DOB can't be in future")
	private Date birthDate;
	public Integer getID() {
		return ID;
	}
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
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
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
