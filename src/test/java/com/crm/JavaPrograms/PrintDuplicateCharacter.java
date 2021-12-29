package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class PrintDuplicateCharacter {

	public static void main(String[] args) {
		
		String s = "nayana";
		
		//Step-1 : Create any SET collection and add all the char of given String into set
		LinkedHashSet<Character> set = new LinkedHashSet<Character>(); //<Character> - to make it generic
		
		for(int i=0; i<s.length(); i++) {
			
			set.add(s.charAt(i));
			
		}
		System.out.println(set);
		
		for (Character ch : set) {
			
			int count=0;
		//Step-2 : Compare each char of Set with all the char of given string
			
			for(int i=0; i<s.length(); i++) {
				if(ch==s.charAt(i)) {
					
		//Step-3 : If char matches, increase the count
					count++;
				}
			}
		//Step-4 : Print both DUPLICATE Character and Count
		if(count>1) {
		
			System.out.println(ch+" "+count);
			
		}
			
	}

}

}
