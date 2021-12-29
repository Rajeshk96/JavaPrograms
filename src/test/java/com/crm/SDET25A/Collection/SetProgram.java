package com.crm.SDET25A.Collection;

import java.util.*;
import java.io.*;

public class SetProgram {

	public static void main(String[] args) {
		
		Set<String> s = new HashSet<String>();
		s.add("10");
		s.add("100");
		s.add("100");
		s.add(null);
		s.add(null); // NULL values are allowed only once
		s.add("5");
					 // HETEROGENEOUS in nature
		s.add("70");
		s.add("20");
		
		System.out.println(s);
		
		// ELEMENTS are displayed in random order
		// FOUR Constructors
		
	}

}
