package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
public static void main(String[] args) {

	// create session factory 
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	
	// create session
	Session session= factory.getCurrentSession();
	try
	{
		
			// use the session object to save the world
		
		// create 3 student object
		System.out.println("create 3 student object");
		Student tempstudent = new Student("Nitin", "Bharadwaj", "kratra@uncc.edu");	
		Student tempstudent1 = new Student("Karan", "Bharadwaj", "nratra@uncc.edu");	
		Student tempstudent2 = new Student("Shivanee", "Bharadwaj", "shivaneesaini@uncc.edu");	
		
		//start the transaction
		session.beginTransaction();
		session.save(tempstudent);
		session.save(tempstudent1);
		session.save(tempstudent2);
		// commit transaction
		
		session.getTransaction().commit();
		System.out.println("done");
	}
	finally {
		factory.close();
	}
	
	

}
}
