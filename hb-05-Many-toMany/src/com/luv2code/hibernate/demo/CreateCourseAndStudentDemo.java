package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			session.beginTransaction();
			//create a course
			Course course = new Course("Pacman11");
			//save a course
			session.save(course);
			System.out.println("saved the course:"+course);
			 
			//System.out.println(course.getReviews());
			//create the students
			
			Student stu1 = new Student("John","Due","john@luv2code.com");
			Student stu2= new Student("Mary","Public","mary@luv2code.com");
			
			//add the student to course
			course.add(stu1);
			course.add(stu2); 
			System.out.println("\nsaving the students");
			//save the student
			session.save(stu1);
			session.save(stu2);
			System.out.println("Saved Students:"+course.getStudents());
			
			 
			 
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





