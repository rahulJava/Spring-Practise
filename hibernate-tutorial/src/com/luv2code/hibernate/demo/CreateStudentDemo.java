package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo 
{
	public static void main(String[] args) {
		// create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		try
		{
			
				// use the session object to save the world
			
			// create the student object
			System.out.println("create a new student object");
			Student student = new Student("Rahul", "Bharadwaj", "rratra@uncc.edu");	
			
			//start the transaction
			session.beginTransaction();
			session.save(student);
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
		
		
	}

}
