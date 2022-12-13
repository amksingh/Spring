package com.aman.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ama.entity.Instructor;
import com.ama.entity.InstructorDetails;


public class GetInstructorDetails {

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
			
			//get the instrcutor details object
			int theId=2;
			InstructorDetails temp=session.get(InstructorDetails.class, theId);
			
			//print thr instructor details
			System.out.println("tempInstructorDetails "+temp);
			//get the associated object with it 
			Instructor t1=temp.getInstructor();
			
			
			
			//print the instrcutor
			System.out.println("the associated instructor details is "+t1);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
