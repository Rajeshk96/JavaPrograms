package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class PrintDuplicateWordInString {

	public static void main(String[] args) {
		
		String s = "Welcome to to Welcome";
		
		String[] str = s.split(" ");
		
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		for(int i=0; i<str.length; i++) {
			
			set.add(str[i]);    
			
		}
		
		for(String st : set) {
			
			int count = 0;
			for(int i=0; i<str.length; i++) {
				
				if(st.equals(str[i])) {
					
					count++;
					
				}
			}
		if(count>1) {
			System.out.print(st+" ");
		}
		
		}

	}

}
