package com.luv2code.springdemo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.customer;
@Service
public class Customerserviceimpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<customer> getCustomers() {
		// TODO Auto-generated method stub
		
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(customer theCustomer) {
		customerDao.saveCustomer(theCustomer);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public customer getCustomers(int theID) {
		// TODO Auto-generated method stub
		return customerDao.getCustomers(theID);
		//return null;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		 customerDao.deleteCustomer(theId);
		// TODO Auto-generated method stub
		
	}
	

}
