package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
		int studentId =3;
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student myStudent = session.get(Student.class, studentId);
		myStudent.setFirstName("muhammad umar");
		myStudent.setLastName("tariq rashid");
		myStudent.setEmail("umartariqx94@gmail.com");
		session.getTransaction().commit();
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
														
		
	}
}
