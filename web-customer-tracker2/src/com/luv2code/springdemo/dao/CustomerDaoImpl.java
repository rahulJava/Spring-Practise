package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {
	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<customer> getCustomers() {
		//get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		System.out.println("Inside line no 29");
		//create query
		 Query<customer> theQuery= currentSession.createQuery("from customer",customer.class);
		
		//execute query
		 List<customer> customerList = theQuery.getResultList();
		
		// return the customer
		
		 return customerList;
	}

}
