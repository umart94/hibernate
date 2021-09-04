package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class,theId);
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			
			
			//to do a cascade delete on only the instructor detail
			//we need to break the bidirectional link between instructor and instructordetail
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				sessionFactory.close();
			}
	}
}
