package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteMarDemo2 {

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
			
			 
			// get the student mary from database 
			int studentID = 4;
			Student tempStudent = session.get(Student.class, studentID);
			System.out.println("\nLoaded Studemnt:"+tempStudent);
			System.out.println("get courses:"+tempStudent.getCourses());
			session.delete(tempStudent);
			System.out.println("\nDeleted Studemnt:"+tempStudent);
			System.out.println("get courses:"+tempStudent.getCourses());
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





