package com.aman.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ama.entity.Instructor;
import com.ama.entity.InstructorDetails;


public class DeleteInstructorDeleteDemo {

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
			
			
			//delete the instructor details
			System.out.println("deleting tempinstructor detail "+temp);
			session.delete(temp);
			
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
