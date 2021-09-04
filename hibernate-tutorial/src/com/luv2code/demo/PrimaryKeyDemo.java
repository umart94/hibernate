package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

Session session = sessionFactory.getCurrentSession();

try {
Student tempStudent1 = new Student("john","doe","paul@luv2code.com");
Student tempStudent2 = new Student("mary","public","paul@luv2code.com");
Student tempStudent3 = new Student("umar","tariq","paul@luv2code.com");
session.beginTransaction();
session.save(tempStudent1);
session.save(tempStudent2);
session.save(tempStudent3);
session.getTransaction().commit();
}catch(Exception e) {
e.printStackTrace();
} finally {
sessionFactory.close();
}

	}
}
