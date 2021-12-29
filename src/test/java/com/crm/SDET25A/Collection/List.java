package com.crm.SDET25A.Collection;

import java.util.ArrayList;

public class List {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(50);   // DUPLICATES are allowed
		list.add(50);
		list.add(null); // NULL values are allowed
		list.add(null);
		list.add("Raj");
		list.add("kumar"); // HETEROGENEOUS in nature
		list.add(40);
		list.add(100);
		
		System.out.println(list);
		
		// INSERTION ORDER is maintained

	}

}
