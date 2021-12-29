package com.crm.SDET25A.Collection;

import java.util.TreeSet;

public class TreesetProgram {

	public static void main(String[] args) {
		
		TreeSet set = new TreeSet();
		set.add(10);
		set.add(null);  //NullPointerException 
		set.add("Rajesh");  //Will show error but throw ClassCastException - Homogeneous in Nature
		set.add(100);
		set.add(5);
		set.add(2);
		
		System.out.println(set); // Elements are displayed in Sorted Order
		

	}

}
