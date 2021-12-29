package com.crm.SDET25A.practice;

import java.util.Date;

public class GetCurrentDate {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		String currentDate = date.toString();
		
		System.out.println(currentDate);
		System.out.println(date.getDate());
		System.out.println(date.getMonth());
		System.out.println(currentDate.split(" ")[4]);
		System.out.println(date.getYear());
		
		
		
		
		
	}

}
