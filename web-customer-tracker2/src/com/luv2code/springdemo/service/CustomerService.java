package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.customer;

public interface CustomerService
{
	public List<customer> getCustomers();

	public void saveCustomer(customer theCustomer);

	public customer getCustomers(int theID);

	public void deleteCustomer(int theId);

}
