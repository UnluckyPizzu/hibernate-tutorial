package com.pizzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.pizzu.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		System.out.println("pre factory");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		System.out.println("dopo factory");
		// create session factory
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			
			System.out.println("pre commit");
			
			// start transaction
			session.beginTransaction();
			// save the obj
			Student student = session.get(Student.class, 1);
			// commit transaction
			session.getTransaction().commit();
			System.out.println(student.toString());
			
		}finally {
			factory.close();
		}
	}

}
