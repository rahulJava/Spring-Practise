package com.luv2code.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;


public class EagerLazyDemo {

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
			int id=1;
			session.beginTransaction();
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+"JOIN FETCH i.courses"
															+" where i.id=:theInstructorId",
															Instructor.class);
			query.setParameter("theInstructorId", id);
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor:"+instructor);
			session.getTransaction().commit();
			session.close();
			
			System.out.println(instructor.getCourses());
			
			
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





