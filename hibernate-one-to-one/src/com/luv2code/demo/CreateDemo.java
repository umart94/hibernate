package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class CreateDemo {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			//create the objects
			Instructor tempInstructor = new Instructor("Umar","Tariq","umar@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","luv 2 code !");
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			session.save(tempInstructor);			
			
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				sessionFactory.close();
			}
	}
}
