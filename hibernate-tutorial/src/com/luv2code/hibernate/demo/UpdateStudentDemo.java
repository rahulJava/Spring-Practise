package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {

			
			int studentID=1;
			session.beginTransaction();
			
			// commit transaction

			session.getTransaction().commit();

			System.out.println("Saved Student generated id:" + studentID);
			/*
			 * now get a new session for gettting the data from database.
			 */
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentID);
			System.out.println("updating student" + student);
			student.setFirstName("ShivJi");
			/*
			 * commit the transaction
			 */
			session.getTransaction().commit();
			;

			 session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("update student with student id = 2");
			session.createQuery("update Student s set email='rratra@googleofficial.com' where id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("done");

			// My new code

		} finally {
			factory.close();
		}

	}

}
