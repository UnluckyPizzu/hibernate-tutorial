package com.pizzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.pizzu.hibernate.demo.entity.Student;

import antlr.collections.List;

public class QueryStudentDemo {

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
			java.util.List<Student> student = session.createQuery("from Student").getResultList();
			java.util.List<Student> studentSingle = session.createQuery("from Student s where s.firstName ='Pippo'").getResultList();
			// commit transaction
			session.getTransaction().commit();
			for (Student student1 : student) {
				System.out.println(student1.toString());
			}
			System.out.println(studentSingle.toString());
			
		}finally {
			factory.close();
		}
	}

}
