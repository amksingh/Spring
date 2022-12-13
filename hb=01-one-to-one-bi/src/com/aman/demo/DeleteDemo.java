package com.aman.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ama.entity.Instructor;
import com.ama.entity.InstructorDetails;


public class DeleteDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory=new Configuration().configure()
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Instructor.class).buildSessionFactory();
		//create the session
		Session session=factory.getCurrentSession();
		
		try{
			
			
			//start the transaction
			session.beginTransaction();
			
			//get instructor by the primary key
			int theId=1;
			Instructor temInstructor=session.get(Instructor.class, theId);
			System.out.println("Found Instructor "+temInstructor);
			
			//delete the instructor
			if(temInstructor!=null)
			{
				session.delete(temInstructor);
			}
			
			
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
