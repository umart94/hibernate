package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;
import com.luv2code.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Course tempCourse1 = new Course("Java Masterclass");
			session.save(tempCourse1);
			Student tempStudent1 = new Student("umar","tariq","umar@gmail.com");
			Student tempStudent2= new Student("umar","tariq","umar@gmail.com");
			Student tempStudent3 = new Student("umar","tariq","umar@gmail.com");
			tempCourse1.addStudent(tempStudent1);	
			tempCourse1.addStudent(tempStudent2);	
			tempCourse1.addStudent(tempStudent3);	
			session.save(tempStudent1);	
			session.save(tempStudent2);	
			session.save(tempStudent3);	
			
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				sessionFactory.close();
			}
	}
}
