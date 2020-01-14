package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			int id=1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("found instructor:"+instructor);
			if(instructor!=null)
			{
				session.delete(instructor);
			}
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





