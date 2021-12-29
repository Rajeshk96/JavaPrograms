package com.crm.SDET25A.Collection;

import java.util.HashMap;

public class Map {

	public static void main(String[] args) {
		
		HashMap hm = new HashMap();
		hm.put(12, 35);
		//hm.put(12, 35); //DUPLICATE values are not allowed
		hm.put(20, 27);
		hm.put(10, 06);
		hm.put("Raj", "kumar");
		hm.put("MARAN", "AMUDHA");
		hm.put(10, 06);
		hm.put(null, 06); //NULL values are allowed only once w.r.t KEYS
		hm.put(null, 07);
		hm.put(21, null); //NULL values are allowed multiple times w.r.t VALUES
		hm.put(22, null);
		hm.put(23, null);
		hm.put(100, 99);
		hm.put(77, 66);
		
		System.out.println(hm);
		
		//Elements are displayed in random order

	}

}
