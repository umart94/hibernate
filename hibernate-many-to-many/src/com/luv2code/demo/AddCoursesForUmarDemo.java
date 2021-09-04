package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;
import com.luv2code.demo.entity.Student;

public class AddCoursesForUmarDemo {

	
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
			int theStudentId = 1;
			Student umarStudent = session.get(Student.class,theStudentId);
			
			Course tempCourse1 = new Course("c# masterclass");
			Course tempCourse2 = new Course("android masterclass");
			Course tempCourse3 = new Course("go masterclass");
			
			tempCourse1.addStudent(umarStudent);
			tempCourse2.addStudent(umarStudent);
			tempCourse3.addStudent(umarStudent);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			
			
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
				sessionFactory.close();
			}
	}
}
