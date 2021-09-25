package com.crudapp.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crudapp.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("Mustufa1", "Khan", "smustufaqadri@gmail.com");
			Student tempStudent2 = new Student("Mustufa2", "Khan", "smustufaqadri@gmail.com");
			Student tempStudent3 = new Student("Mustufa3", "Khan", "smustufaqadri@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving 3 student objects...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();		
		} finally {
			factory.close();
		}
	}

}
