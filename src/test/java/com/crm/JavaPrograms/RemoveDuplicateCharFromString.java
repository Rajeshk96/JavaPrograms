package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class RemoveDuplicateCharFromString {

	public static void main(String[] args) {
		
		String s = "india";
		
		//Step-1 : Create any SET collection and add all the char of given String into set
		LinkedHashSet<Character> set = new LinkedHashSet<Character>(); //<Character> - to make it generic
		
		for(int i=0; i<s.length(); i++) {
			
			set.add(s.charAt(i));
			
		}
		//System.out.println(set);
		
		for(char ch : set) {
			
			System.out.print(ch);  //1st introduced(i) is not duplicate, if repeated then it is duplicate
			
		}

	}

}
