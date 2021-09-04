package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
		int studentId =4;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("delete from Student where id=4").executeUpdate();
		
		session.getTransaction().commit();
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
														
		
	}
}
