package com.aman.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class TestJdbc {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee_tracker?useSSL=false&serverTimezone=UTC";
		String user="employee";
		String pass="employee";
		try {
			System.out.println("connecting to database: "+url);
			
			Connection conn=DriverManager.getConnection(url,user,pass);
			System.out.println("connection succesful");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
