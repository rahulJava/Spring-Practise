package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc
{
public static void main(String[] args) {
	
	String jdbcurl= "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
	String user="hbstudent";
	String pass="hbstudent";
	try
	{
	
		System.out.println("connect to database");
		Connection myconn= DriverManager.getConnection(jdbcurl,user,pass);
		System.out.println("Connection Successful");
	}
	catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
}
}
