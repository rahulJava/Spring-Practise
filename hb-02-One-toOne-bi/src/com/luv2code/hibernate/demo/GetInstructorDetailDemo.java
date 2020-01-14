package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;

public class GetInstructorDetailDemo {

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
			int theID=3;
			InstructorDetails instructorDetails = session.get(InstructorDetails.class, theID);
			
			System.out.println(instructorDetails);
			System.out.println("instructor details:"+instructorDetails.getInstructor());
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





