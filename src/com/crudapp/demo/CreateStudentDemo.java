package com.crudapp.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crudapp.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Mustufa", "Khan", "smustufaqadri@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving new student object...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();		
		} finally {
			factory.close();
		}
	}

}
