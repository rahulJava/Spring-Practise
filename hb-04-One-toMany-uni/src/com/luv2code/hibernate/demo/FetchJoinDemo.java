package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			int theID=1;
			Instructor tempInstructor = session.get(Instructor.class, theID);
			
			System.out.println("Instructor:"+tempInstructor);
			
			System.out.println("Courses:"+tempInstructor.getCourses());
			session.getTransaction().commit();
			session.close();
			
			System.out.println("the session is now closed");
			System.out.println("Courses:"+tempInstructor.getCourses());
			
			System.out.println("done");
			
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





