package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseandReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			
			Course course = new Course("Pacman1 ");
			course.add(new Review("Great course loved it"));
			course.add(new Review("Wow lovely course loved it"));
			course.add(new Review("Wow Loving it"));
			 
			System.out.println(course.getReviews());
			
			session.save(course);
			 
			 
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





