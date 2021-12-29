package com.crm.SDET25.GenericUtils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String readDataFromJson(String key) throws Throwable {
		
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(IPathConstants.JSON_PATH);
		Object object = parser.parse(reader);
		JSONObject jsonobj = (JSONObject)object;
		return jsonobj.get(key).toString();
	}

}
