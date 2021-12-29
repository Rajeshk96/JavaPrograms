package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class CharPositionInString {

	public static void main(String[] args) {
		
		String str = "Tester";
		String s=str.toLowerCase();
		
		//Step-1 : Create any SET collection and add all the char of given String into set
		LinkedHashSet<Character> set = new LinkedHashSet<Character>(); //<Character> - to make it generic
		
		for(int i=0; i<s.length(); i++) {
			
			set.add(s.charAt(i));
			
		}
		System.out.println(set);
		
		for (Character ch : set) {
			
		//Step-2 : Compare each char of Set with all the char of given string
			
			for(int i=0; i<s.length(); i++) {
				if(ch==s.charAt(i)) {
					
		//Step-3 : 
					System.out.println(ch+" "+(i+1));
					break;
				}
			}			
		}

	}

}
