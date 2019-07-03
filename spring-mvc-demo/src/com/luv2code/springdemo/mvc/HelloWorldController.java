package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/hello")
public class HelloWorldController 
{
	@RequestMapping("/showForm")
	public String showForm()
	{
		
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}

	
	//new controller methodto read form data 
	// and data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model)
	{
		//read the request parameter from the HTML form
		
		String theName = request.getParameter("studentName");
		
		theName= theName.toUpperCase();
		String result ="Yo! "+ theName;
		model.addAttribute("message",result );
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model)
	{
		//read the request parameter from the HTML form
		
		theName= theName.toUpperCase();
		String result ="Hey My God please be with me always! "+ theName;
		model.addAttribute("message",result );
		return "helloworld";
	}
	
}
