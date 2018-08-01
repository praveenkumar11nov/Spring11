package com.web.apps.HelperClasses;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@Controller
public class WebServices {
	
	@RequestMapping(value="/getDataFromApplication",method={RequestMethod.GET},produces="application/json")
	public @ResponseBody String getdataFromApp() {
		
		return getResponse();
	}

	public String getResponse() {
		JSONObject response=new JSONObject();
		JSONArray response1=new JSONArray();
		JSONObject response2=new JSONObject();
		JSONObject response3=new JSONObject();
		try {
			response2.put("name","Praveen");
			response2.put("address","Bangalore");
			response2.put("mobile","9738716976");
			response2.put("email","praveen.kumar@bcits.in");
			
			response3.put("name","Kumar");
			response3.put("address","Delhi");
			response3.put("mobile","7205606332");
			response3.put("email","kumar@bcits.in");
			
			response1.put(response2);
			response1.put(response3);
			response.put("data",response1);
		} 
		catch (Exception e) {
			
		}
		return response.toString();
	}
	
	
}
