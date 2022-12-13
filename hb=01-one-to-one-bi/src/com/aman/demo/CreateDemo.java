package com.aman.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ama.entity.Instructor;
import com.ama.entity.InstructorDetails;


public class CreateDemo {

	public static void main(String[] args) {
	
		//create session factory
		SessionFactory factory=new Configuration().configure()
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Instructor.class).buildSessionFactory();
		//create the session
		Session session=factory.getCurrentSession();
		
		try{
			//create the object 
		InstructorDetails tempinInstructorDetails=new InstructorDetails("http://www.ama.com/youtube"
				,"cricket");
		Instructor teInstructor=new Instructor("aman","kumar","aman@gmail.com");
			
			InstructorDetails temp1=new InstructorDetails("http://youtube.yahoo"
					,"TableTennis");
			Instructor temp11=new Instructor("sunidhi","mishra","Somi@gmail.com");
			
			
			//associate the objects
			teInstructor.setInstructorDetails(tempinInstructorDetails);
			temp11.setInstructorDetails(temp1);
			
			
			//start the transaction
			session.beginTransaction();
			session.save(teInstructor);
			session.save(temp11);
			
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
