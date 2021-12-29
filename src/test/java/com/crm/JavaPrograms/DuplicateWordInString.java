package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class DuplicateWordInString {

	public static void main(String[] args) {
		
		String s = "Welcome to to Welcome bangalore";
		
		String[] str = s.split(" ");
		
		//Step-1 : Create any SET collection and add all the char of given String into set
		LinkedHashSet<String> set = new LinkedHashSet<String>(); //<Character> - to make it generic
		
		for(int i=0; i<str.length; i++) {
			
			set.add(str[i]);
			
		}
		//System.out.println(set);
		
		for(String st : set) {
			
			System.out.print(st+" ");  //1st introduced(i) is not duplicate, if repeated then it is duplicate
			
		}

	}

}
