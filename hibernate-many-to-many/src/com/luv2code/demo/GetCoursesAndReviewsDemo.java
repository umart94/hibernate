package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;

public class GetCoursesAndReviewsDemo {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				sessionFactory.close();
			}
	}
}
