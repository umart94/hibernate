package com.luv2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

Session session = sessionFactory.getCurrentSession();

try {
session.beginTransaction();
List<Student> theStudents = session.createQuery("from Student").getResultList();
for (Student s : theStudents) {
	System.out.println(s.toString());
}
session.getTransaction().commit();



}catch(Exception e) {
e.printStackTrace();
} finally {
sessionFactory.close();
}
	
		
		
	}
}
