package com.aman.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		//here we have to give the schema name which we are using
		String url="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeone=UTC";
		String user="employee";
		String pass="employee";
		
		try {
			Connection conn=DriverManager.getConnection(url,user,pass);
			System.out.println("the connection is succesful");
			
			
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}

	}

}
