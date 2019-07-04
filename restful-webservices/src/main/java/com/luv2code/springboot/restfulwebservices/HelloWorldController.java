package com.luv2code.springboot.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller This is going to handle the rest request .
@RestController
public class HelloWorldController 
{

	//Get Method
	//URI HelloWorld
	//Method Hello World
	//you can also go with @GetMapping with that you no need to specify the request method = get
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
}
