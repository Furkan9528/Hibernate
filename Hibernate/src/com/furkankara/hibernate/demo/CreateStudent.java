package com.furkankara.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkankara.hibernate.demo.entity.Student;


public class CreateStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create a student object
						System.out.println("Creating new student object...");
						Student tempStudent = new Student("Mashar", "KARA", "mashar@com");
						
						// start a transaction
						session.beginTransaction();
						
						// save the student object
						System.out.println("Saving the student...");
						session.save(tempStudent);
						
						// commit transaction
						session.getTransaction().commit();
						
						System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
