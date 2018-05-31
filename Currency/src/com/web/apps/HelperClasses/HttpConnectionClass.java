package com.web.apps.HelperClasses;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
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
}