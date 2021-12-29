package com.crm.JavaPrograms;

public class FirstLetterUppercase {

	public static void main(String[] args) {
		
		    String s = "welcome to tyss";
		    
		    String[] str = s.split(" ");
		    for(int i=0; i<str.length; i++) {
		    	
		    	String s1 = ""+str[i].charAt(0);
		    	   System.out.print(s1.toUpperCase()+str[i].substring(1)+" ");
		    	   
		    	  /*
		    	for(int j=1; j<str[i].length(); j++) {
		    		System.out.print(str[i].charAt(j));
		    	}
		    	System.out.print(" ");
		    	*/
		    }
	}

}
