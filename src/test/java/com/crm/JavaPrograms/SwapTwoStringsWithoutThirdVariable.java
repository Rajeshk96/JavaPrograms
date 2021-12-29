package com.crm.JavaPrograms;

public class SwapTwoStringsWithoutThirdVariable {

	public static void main(String[] args) {
		
		String s1="java";    //4
		String s2="selenium";//8
		
		s1 = s1+s2; //java+selenium => 12
		
		s2 = s1.substring(0, s1.length()-s2.length()); // (0, 12-8) => (0,4) => java
		
		s1 = s1.substring(s2.length()); //4
		
		System.out.println(s1);
		System.out.println(s2);

	}

}
