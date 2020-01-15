package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the DAO 
	
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping("/list")
	public String listCustomers(Model model)
	{
		
		//get the customer from dao and that to my spring mvc model.
		List<customer> customliList=customerDao.getCustomers();
		
		model.addAttribute("customer",customliList);
		return "list-customers";
	}

}
