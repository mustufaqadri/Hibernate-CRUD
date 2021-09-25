package com.crudapp.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crudapp.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("King2", "Qadri", "smustufaqadri@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving new student object...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the primary key
			System.out.println("Saved Student Generated id : " + tempStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student using id
			System.out.println("\n Getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("\n Fetched Student: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}
	}

}
