package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class SumOfDigitInString {

	public static void main(String[] args) {
		
		String s = "ab44&7$d";
		
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		
		for(int i=0; i<s.length(); i++) {
			
			set.add(s.charAt(i));
			
		}
		int sum=0;
		int num=0;
		for(char ch : set) {
			
			if(ch>=48 && ch<=57) {
				num = Character.getNumericValue(ch);
				sum = sum+num;
			}
		}
		System.out.println(sum);	
	}
/*
 * String s = "a1$b23";
 * int sum = 0;
 * for(int i =0; i<s.length(); i++)
 * {
 *   if(s.chartAt(i)>='0' && s.charAt(i)<='9'){
 *     
 *     int n = s.charAt(i)-48;
 *     sum = sum+n;
 *     }
 *  }
 *  s.o.pln(sum);
 *  
 * 
 */
}
