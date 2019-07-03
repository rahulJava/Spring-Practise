package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo2 {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {

			// use the session object to save the world

			// create the student object
			System.out.println("create a new student object");
			Student tempstudent = new Student("Daffy", "Duck", "luv2code.com");

			// start the transaction
			session.beginTransaction();
			System.out.println("Saving the student" + tempstudent);
			session.save(tempstudent);
			// commit transaction

			session.getTransaction().commit();

			System.out.println("Saved Student generated id:" + tempstudent.getId());
			/*
			 * now get a new session for gettting the data from database.
			 */
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("temp student id:" + tempstudent.getId());
			Student student = session.get(Student.class, tempstudent.getId());
			System.out.println("get complete :" + student);
			/*
			 * commit the transaction
			 */
			session.getTransaction().commit();
			;

			System.out.println("done");

			// My new code

		} finally {
			factory.close();
		}

	}

}
