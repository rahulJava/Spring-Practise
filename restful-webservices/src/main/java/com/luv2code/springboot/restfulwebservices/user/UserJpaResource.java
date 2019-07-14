package com.luv2code.springboot.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource 
{
	public UserJpaResource() {
		super();
	}
	@Autowired
	private UserDaoService service;
	@Autowired 
	private UserRepository userRepository;
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers()
	{
		return userRepository.findAll();
	}
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retriveUser(@PathVariable int id)
	{
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent())
		{
			throw new UsernotFoundException("id :"+id);
		}
		Resource<User> resource  = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retriveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createuser(@Valid @RequestBody User user )
	{
		User savedUser =userRepository.save(user);
		//Response entity used for returning the status code back
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequestUri()
		.path("/{id}")
		.buildAndExpand(savedUser.getID()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
	}
}
