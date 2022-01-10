package com.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.entity.Areacity;
import com.demo.entity.Bill;
import com.demo.entity.Category;
import com.demo.entity.Customer;
import com.demo.entity.Department;
import com.demo.entity.Employee;
import com.demo.entity.Job;
import com.demo.entity.Manufacturer;
import com.demo.entity.Product;
import com.demo.entity.Productsbought;
import com.demo.entity.Shop;
import com.demo.entity.Subcategory;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Areacity.class)
				.addAnnotatedClass(Bill.class)
				.addAnnotatedClass(Bill.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Department.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Job.class)
				.addAnnotatedClass(Manufacturer.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Productsbought.class)
				.addAnnotatedClass(Shop.class)
				.addAnnotatedClass(Subcategory.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			//create the objects
			
			
			session.beginTransaction();
			//start a transaction
			
			//String HQL = "select e from Shop e inner join e.areacity";
			String HQL = "select e from Shop e inner join e.areacity";
			
			
			Query query = session.createQuery(HQL);
			List results = query.list();
			System.out.println(results.toString());
			session.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				sessionFactory.close();
			}
	}
}
