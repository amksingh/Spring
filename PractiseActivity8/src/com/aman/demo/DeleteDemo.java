package com.aman.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aman.entity.Employee;

//this is the always error we need to import hibernate 
//import com.mysql.cj.xdevapi.SessionFactory;


public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Employee emp=session.get(Employee.class, 2);
			session.delete(emp);
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		

	}

}
