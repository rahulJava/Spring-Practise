package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetails;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCourseForMarDemo {

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
			int studentID = 2;
			Student tempStudent = session.get(Student.class, studentID);
			System.out.println("Mary:"+tempStudent);
			System.out.println("\n"+tempStudent.getCourses());
			//create more courses
			Course tempCourse1= new Course("Rubik cubes -How to speed cube");
			Course teCourse2 = new Course("2165 Artificial Intelligence");
			
			tempCourse1.add(tempStudent);
			teCourse2.add(tempStudent);
			session.save(tempCourse1);
			session.save(teCourse2);  
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





