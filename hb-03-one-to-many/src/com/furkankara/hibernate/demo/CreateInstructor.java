package com.furkankara.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.furkankara.hibernate.demo.entity.Course;
import com.furkankara.hibernate.demo.entity.Instructor;
import com.furkankara.hibernate.demo.entity.InstructorDetail;


public class CreateInstructor {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
	try {			
		 
			// create the object
			Instructor tempInstructor= new Instructor("Sibel","KARA", "sibel@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.sibel.com","Luv 2 code!!"); 
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			// start a transaction
			session.beginTransaction();
			
			//save the instructor
			//Note: this will ALSO save the details object
			//beacuse of CascadeType.ALL
			//
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
	}
		finally {
			// add clean up code
			factory.close();
		}
	}

	
}
