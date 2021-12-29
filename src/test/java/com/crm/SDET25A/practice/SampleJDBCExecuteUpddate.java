package com.crm.SDET25A.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpddate {

	@Test
	public void SampleJDBCExecuteUpdate() throws Throwable {
		
		Connection conn=null;
		try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","root");
		
		Statement stat = conn.createStatement();
		
		int result = stat.executeUpdate("insert into studentinfo ('umak',07,'katpadi');");
		
		if(result==1) {
			System.out.println("data added to table");
		}
		else
		{
			System.out.println("data not added");
		}
	}
		catch(Exception e) 
		{
			
		}
		finally {
			conn.close();
			System.out.println("connection is closed");
		}
	}

}
