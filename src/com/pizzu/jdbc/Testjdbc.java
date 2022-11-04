package com.pizzu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Testjdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			Connection myConnection= DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Let's try");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
