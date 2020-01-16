package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the DAO 
	
	@Autowired
	private CustomerService customerService;
//	@Autowired
//	private CustomerDao customerDao;
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		
		//get the customer from dao and that to my spring mvc model.
		List<customer> customliList=customerService.getCustomers();
		
		model.addAttribute("customer",customliList);
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showForForAdd(Model model)
	{
		customer customer = new customer();
		model.addAttribute("customer",customer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer") customer theCustomer)
		{
		//save the customer
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
		}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theID,
			Model theModel)
	{
		
		//get the customer for update
		customer theCustomer = customerService.getCustomers(theID);
		//set customer as model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		//send ot over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
