package com.web.apps.HelperClasses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebServices {
	
	@RequestMapping(value="/getDataFromApplication",method={RequestMethod.GET},produces="application/json")
	public @ResponseBody String getdataFromApp() {
		String name=null,position=null,salary=null,start_date=null,office=null,extn=null;
		
		String Response=
			
			"{\"data\":["+
			
			"{"+
			"\"name\":\"Sachin\","+
			"\"position\":\"Developer\","+
			"\"salary\":\"$320,800\","+
			"\"start_date\":\"2011/04/25\","+
			"\"office\":\"Edinburgh\","+
			"\"extn\":\"5421\""+
			"},"+
			
			"{"+
			"\"name\":\"Vinay\","+
			"\"position\":\"Developer\","+
			"\"salary\":\"$320,800\","+
			"\"start_date\":\"2011/04/25\","+
			"\"office\":\"Edinburgh\","+
			"\"extn\":\"5421\""+
			"},"+
			
			"{"+
			"\"name\":\"Praveen\","+
			"\"position\":\"Developer\","+
			"\"salary\":\"$320,800\","+
			"\"start_date\":\"2011/04/25\","+
			"\"office\":\"Edinburgh\","+
			"\"extn\":\"5421\""+
			"}"+
			
			
			"]}";
		
		
		System.out.println("Response="+Response);
		return Response;
	}
}
