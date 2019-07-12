package com.web.apps.HelperClasses;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Controller
public class ApiBasicAuthentication {
	
	public static final String usernameForApi = ResourceBundle.getBundle("configuration").getString("APIUSERNAME");
	public static final String passwordForApi = ResourceBundle.getBundle("configuration").getString("APIPASSWORD");
	
	@ResponseBody
	@RequestMapping(value="/getDataFromApplication",method={RequestMethod.POST},produces="application/json")
	public String getdataFromApp(@RequestHeader("Auth")String Auth) throws JSONException {
		
		System.out.println("Auth = " + Auth);
		if(isUserAuthenticated(Auth)) 
		{
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
		else{
			return new JSONObject().put("ERROR","YOU ARE NOT AUTHORISED").toString();
		}
	}
	
	private boolean isUserAuthenticated(String authString){
        try {
        	String decodedAuth = "";
        	String[] authParts = authString.split("\\s+");
        	String authInfo = authParts[1];
        	byte[] bytes = null;
        	bytes = Base64.decode(authInfo);
        	decodedAuth = new String(bytes);
        	System.out.println(decodedAuth);
        	String[]verify=decodedAuth.split(":");
        	
        	if(verify[0].equalsIgnoreCase(usernameForApi)) {
        		if(verify[1].equalsIgnoreCase(passwordForApi)) {
        			return true;        		
        		}else{
        			return false;
        		}
        	}else{
        		return false;
        	}
			
		} catch (Exception e) {
			return false;
		}
      
    }
}
