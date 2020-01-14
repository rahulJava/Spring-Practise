package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo 
{
	public static void main(String[] args) {
		// create session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		try
		{
			
			// use the session object to save the world
			
			
			//start the transaction
			session.beginTransaction();
			// query students
			
			List<Student> theStudents = session.createQuery("from Student").list();
			//display the students
			
			displayMethod(theStudents);
			System.out.println("---------");
			// query students with lastname Bharadwaj
			theStudents=session.createQuery("from Student s where s.firstName ='Nitin'").list();
			System.out.println("line no 35");
			displayMethod(theStudents);
			
			System.out.println();
			//query students lastname Bharadwaj or firstname daffy
			
			theStudents=session.createQuery("from Student s where s.lastName='Bharadwaj'"+ "or s.firstName='sankhi'").getResultList();
			System.out.println("concated");
			displayMethod(theStudents);
			System.out.println();
			theStudents=session.createQuery("from Student s where s.email like '%uncc.edu'").list();
			displayMethod(theStudents);
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayMethod(List<Student> theStudents) {
		for(Student tempStudent:theStudents )
		{
			System.out.println(tempStudent);
		}
	}

}
