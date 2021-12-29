package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class SplCharAndNumSeperation {
	
	public static void main(String[] args) {
		
		String s = "ab122&4$d";
		String alp = "";
		String num = "";
		String spl = "";
		
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		
		for(int i=0; i<s.length(); i++) {
			
			set.add(s.charAt(i));
			
		}
		
		for(char ch : set) {
			
			if(ch>=97 && ch<=122 || ch>=65 && ch<=90) {
				
				alp = alp + ch;
			}
			if(ch>=49 && ch<=54) {
				
				num = num + ch;
			}
			if(ch>=33 && ch<=47) {
				
				spl = spl + ch;
			}
			
		}
		
		System.out.println(alp+" is a character");
		System.out.println(num+" is a Integer");
		System.out.println(spl+" is a Special Character");
		
	}

}
