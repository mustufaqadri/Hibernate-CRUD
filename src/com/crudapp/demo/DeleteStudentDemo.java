package com.crudapp.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crudapp.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a student object
			Student tempStudent = session.get(Student.class, 3);
			System.out.println(tempStudent);
			  
			session.delete(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
