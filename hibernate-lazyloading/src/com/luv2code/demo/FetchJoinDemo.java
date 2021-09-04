package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId = 1;
			
			
			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId"
					,Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId",theId);
			
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println(tempInstructor);
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println(tempInstructor.getCourses());
			
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				sessionFactory.close();
			}
	}
}
