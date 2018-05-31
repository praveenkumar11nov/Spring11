package com.web.apps.HelperClasses;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class EncryptString {
	public static void main(String[]agrs){
		String str="praveen";
		System.out.println("Encoded value of "+str+" is "+enCode(str));
		System.out.println("Decoded value "+enCode(str)+" is "+deCode(enCode(str)));
	}
	
	public static String enCode(String str){
		return Base64.encode(str.getBytes());
	}
	
	public static String deCode(String bytesEncoded){
		return new String(Base64.decode(bytesEncoded));
	}
}