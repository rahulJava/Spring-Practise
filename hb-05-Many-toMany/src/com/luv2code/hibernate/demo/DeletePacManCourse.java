package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacManCourse {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			//start transactioon
			session.beginTransaction();
			 int courseId=13;
			 Course tempCourse= session.get(Course.class, courseId);
			 //delete a course
			 
			 System.out.println("temp course:"+tempCourse);
			 session.delete(tempCourse);
			
			//begin transaction
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





