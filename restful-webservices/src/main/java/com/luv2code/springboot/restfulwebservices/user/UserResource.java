package com.luv2code.springboot.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource 
{
	@Autowired
	private UserDaoService service;
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return service.findAll();
	}
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id)
	{
		User user=service.findOne(id);
		if(user==null)
		{
			throw new UsernotFoundException("id :"+id);
		}
		return user;
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createuser(@RequestBody User user )
	{
		User savedUser =service.save(user);
		//Response entity used for returning the status code back
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequestUri()
		.path("/{id}")
		.buildAndExpand(savedUser.getID()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user=service.deleteByID(id);
		if(user==null)
		{
			throw new UsernotFoundException("id :"+id);
		}
	
	}
}
