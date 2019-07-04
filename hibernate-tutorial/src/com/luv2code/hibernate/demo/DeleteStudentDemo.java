package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {

			
			int studentID=1;
			session.beginTransaction();
			
//			Student myStudent = session.get(Student.class,studentID);
//			System.out.println("Deleting the student:"+myStudent);
//			session.delete(myStudent);
//			
//			/*
//			 * commit the transaction
//			 */
//			session.getTransaction().commit();
			System.out.println("Deleting the student from HQL");
			session.createQuery("delete from Student s where s.id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("done");

			// My new code

		} finally {
			factory.close();
		}

	}

}
