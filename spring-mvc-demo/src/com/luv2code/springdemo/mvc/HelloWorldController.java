package com.luv2code.springdemo.mvc;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorldController 
{
	@RequestMapping("/showForm")
	public String showForm()
	{
		
		return "helloworld-form";
	}

}
