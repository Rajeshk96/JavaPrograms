package com.crm.SDET25A.Collection;

import java.util.TreeMap;

public class TreemapProgram {

	public static void main(String[] args) {
		
		TreeMap tm = new TreeMap();
		tm.put(11, 22);
		tm.put(77, 66); 
		//tm.put(null, 66); //NULL is not allowed - NullPointerException - For Keys
		tm.put(88, null);
		tm.put(66, null);
		tm.put(99, 55);
		tm.put("Rajesh", 54); // HOMOGENEOUS in nature - ClassCastException
		tm.put(33, 44);
		
		System.out.println(tm);
		
		// Elements are arranged in sorted order

	}

}
