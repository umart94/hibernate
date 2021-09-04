package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class DeleteDemo {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class,theId);
			
			if(tempInstructor!=null) {
				System.out.println("deleting "+tempInstructor);
				session.delete(tempInstructor);		
			}
			
			
			
			
				
			
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				sessionFactory.close();
			}
	}
}
