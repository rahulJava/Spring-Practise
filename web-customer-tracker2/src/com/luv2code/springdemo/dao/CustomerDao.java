package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.customer;

public interface CustomerDao {

	
		public List<customer> getCustomers();

		public void saveCustomer(customer theCustomer);

		public customer getCustomers(int theID);

		public Object deleteCustomer(int theId);
	
}
