package com.crm.JavaPrograms;

public class ReverseStringWithoutLength {

	public static void main(String[] args) {
		
		//Without using Length Method or variable
		
		String s = "Java";
		
		String rev = "";
		
		char [] ch = s.toCharArray();
		int count = 0;
		for(char c : ch) {
			
			count++;
			
		}
		System.out.println(count);
		
		for(int i=count-1; i>=0; i--) {
			
			rev = rev + s.charAt(i);
			
		}
		System.out.println(rev);

	}

}
