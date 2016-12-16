package com.iroiro.spring.hibernate.jsontools;

import net.sf.json.JSONObject;

public class JsonTools {
	public JsonTools(){
		
	}
	public static String createJsonString(String key, Object value){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}
