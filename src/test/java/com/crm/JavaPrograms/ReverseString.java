package com.crm.JavaPrograms;

public class ReverseString {

	public static void main(String[] args) {
		
		
		String s="india";
		
		for (int i=s.length()-1; i>=0; i--) {       // Without using variable
			
			System.out.print(s.charAt(i));
			
		}
		
		
		/*
		String s = "Java";
		
		String rev = "";                           // With variable
		
		for(int i=s.length()-1; i>=0; i--) {
			
			rev = rev + s.charAt(i);
			
		}
		
		System.out.print(rev);
		*/
	}

}
