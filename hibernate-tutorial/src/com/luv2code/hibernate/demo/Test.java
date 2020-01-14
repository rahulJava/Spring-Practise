package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class Test 
{
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update Student s set firstName='rahul' where s.id=5 ").executeUpdate();
		session.getTransaction().commit();
		
		session=factory.getCurrentSession();
		session.beginTransaction();
		Student student= session.get(Student.class, 5);
		student.setFirstName("rahulbaby");
		session.getTransaction().commit();
		
		session=factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update Student s set firstName='Shivanee' where s.id=5").executeUpdate();
		session.getTransaction().commit();
		
		
		
	}

}
