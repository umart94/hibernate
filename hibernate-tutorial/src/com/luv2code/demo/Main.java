package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
		Student tempStudent = new Student("Paul","Wall","paul@luv2code.com");
		session.beginTransaction();
		session.save(tempStudent);
		session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
														
		
	}
}
