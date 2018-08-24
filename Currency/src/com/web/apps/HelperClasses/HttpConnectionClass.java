package com.web.apps.HelperClasses;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jettison.json.JSONObject;
class HttpConnectionClass{
public static void main(String[]args){
System.out.println("ServerResponse=>"+getResponseFrom("http://122.166.211.23:1001/bsmartjvvnl/Jvvnl/BillFecthApi?kno=210911011922","String","POST"));
}
	
	public static String getResponseFrom(String url,String type,String method){
		try{
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)u.openConnection();
			conn.setRequestProperty("Content-Type", "application/"+type);
			conn.setRequestProperty("Accept", "application/"+type);
			conn.setRequestMethod(method);
			String line = "";
			StringBuffer sb = new StringBuffer();
			BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()) );
			while((line = input.readLine()) != null)
				sb.append(line);
			input.close();
			conn.disconnect();
			return sb.toString();
		}catch (Exception e){
			e.printStackTrace();
			return "Exception Came While Fetching Response";
		}
	}
	
	public static String sendResponseToAPI(){
		HttpClient client = new HttpClient();
        client.getParams().setParameter("http.useragent", "Test Client");
        BufferedReader br = null;
        String result="";
        Map<String, Object> data = new HashMap<>();
		try{
			 JSONObject obj = new JSONObject();
	          obj.put("Knumber","");
	          obj.put("ComplaintType", "");
	          obj.put("SubcomplaintType","");
	          obj.put("Remarks", "");
	          System.err.println("obj is "+obj.toString());
	          PostMethod method = new PostMethod("URL");
	          method.addParameter("Knumber","");
	          method.addParameter("ComplaintType", "");
	          method.addParameter("Remarks", "");
	          method.addParameter("SubcomplaintType", "");
	          System.out.println(method.toString());
	          try
	          {
	            int returnCode = client.executeMethod(method);
	            System.out.println("returnCode ==> "+returnCode);
	            if(returnCode == HttpStatus.SC_NOT_IMPLEMENTED)
	            {
	              System.err.println("The Post method is not implemented by this URI");
	              // still consume the response body
	              method.getResponseBodyAsString();
	            }
	            else
	            {
	            	System.out.println("inside else result");
	              br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
	              String readLine;
	              while(((readLine = br.readLine()) != null))
	                  result=result+readLine;
	              System.out.println("result===> "+result);
	              String lastChar =result.substring(1, result.length()-1);
		   	       System.out.println("lastchar -===> "+lastChar);
	              JSONObject j1=new JSONObject(lastChar);
	              System.out.println("j1 "+j1.getString("status"));
	              System.out.println("j2 "+j1.getString("result"));
	              data.put("status", j1.getString("status"));
	              data.put("result", j1.getString("result"));
	            }
	          }
	          catch (Exception e) { 
	        	  e.printStackTrace();
	          }
	         System.out.println("======================"+result+"================================");
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	/*
	{
		StringEntity se=new StringEntity(obj.toJSONString());
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request=new HttpPost("http://182.18.140.195:7070/bsmartmdmDHBVN/email/1234");
		request.setHeader("Content-type", "application/json");
		System.out.println(se);
		request.setEntity(se);
		
		HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
        System.err.println(new BasicResponseHandler().handleResponse(response));

	}
	*/
	
}