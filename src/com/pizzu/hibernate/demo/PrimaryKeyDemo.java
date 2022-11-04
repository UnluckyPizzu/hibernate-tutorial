package com.pizzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pizzu.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("pre factory");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		System.out.println("dopo factory");
		// create session factory
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			
			System.out.println("pre commit");
			
			// create student obj
			Student tempStudent = new Student("Pippo","Creed","bello@gmail.com");
			
			Student temp2Student = new Student("Grabriella","Cuck","kek@gmail.com");
			// start transaction
			session.beginTransaction();
			// save the obj
			session.save(tempStudent);		
			session.save(temp2Student);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("dopo commit");
			
		}finally {
			factory.close();
		}
	}

}
