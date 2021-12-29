package com.crm.SDET25A.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBExecuteQuery {
	
	@Test
	public void SampleJDBExecuteQuery() throws Throwable
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","root");
		
		Statement stat = conn.createStatement();
		
		ResultSet result = stat.executeQuery("select * from studentinfo;");
		
		while(result.next())
		{
			System.out.println(result.getString(1) +" "+result.getString(2));
		}
		
		conn.close();
	}

}
