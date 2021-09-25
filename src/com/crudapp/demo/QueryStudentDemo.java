package com.crudapp.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crudapp.entity.Student;

public class QueryStudentDemo {

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
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Qadri'").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
