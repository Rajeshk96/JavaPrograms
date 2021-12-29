
package com.crm.JavaPrograms;

import java.util.LinkedHashSet;

public class ReverseWordsInString {

	public static void main(String[] args) {
		
		String s = "Welcome to katpadi";
		
		String[] str = s.split(" ");
		
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		for(int i=0; i<str.length; i++) {
			
			set.add(str[i]);    
			
		}
		
		for(String st : set) {
			
			char[] ch = st.toCharArray();
			
			for(int i=st.length()-1; i<st.length(); i--) {
				
				if(i<0)
				{
					System.out.print(" ");
					break;
				}else
				{
				System.out.print(ch[i]);
				}
			}
	
		}

	}

}
/*
 * String[] str = s.split(" ");
 * String rev = "";
 * for(int i=str.length-1; i>=0; i--){
 * rev = rev+str[i]+" ";
 * }
 * s.o.pln(rev);
*/