package com.pizzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.pizzu.hibernate.demo.entity.Student;

import antlr.collections.List;

public class UpdateStudentDemo {

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
			// use class param
			Student myStudent = session.get(Student.class, 1);
			myStudent.setFirstName("Pippone");			
			// commit transaction
			
			session.createQuery("Update Student set firstName ='noMorePippo' where firstName='Pippo'").executeUpdate();
			session.getTransaction().commit();			
			
		}finally {
			factory.close();
		}
	}

}
