package com.web.apps.aop;

import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.sun.org.apache.xml.internal.security.utils.Base64;

//@EnableAspectJAutoProxy
@Aspect
@Component
public class PrimaryAspects {
	public static final String usernameForApi = ResourceBundle.getBundle("configuration").getString("APIUSERNAME");
	public static final String passwordForApi = ResourceBundle.getBundle("configuration").getString("APIPASSWORD");
	/*
	@Before("execution(* com.web.apps.HelperClasses.WebServices.*(..))")
	public void myadvice(){
        System.out.println("WEBService Called....");  
    }
	
	@After("execution(* com.web.apps.controller.LoginController.getSuccessPage(..))")
	public void myadvice2(){
		System.out.println("USER LOGGED" );  
	}
*/
    @Pointcut("execution(* com.web.apps.HelperClasses.ApiBasicAuthentication.getdataFromAppTestingAOP(..))")  
    public void abcPointcut(){}  
    
    @Around("abcPointcut() && args(..,request)")  
    public Object myadvice4(ProceedingJoinPoint pjp, HttpServletRequest request) throws Throwable{
    	//System.out.println("Additional Concern Before calling actual method");
    	String auth=String.valueOf(request.getHeader("authentication"));
    	//System.err.println("auth=========="+auth);
    	Object obj;  
    	if(isUserAuthenticated(auth)) {
    		obj=pjp.proceed();  
    	}else{
    		obj=new JSONObject().put("ERROR","YOU ARE NOT AUTHORISED").toString();
    	}
    	//System.out.println("Additional Concern After calling actual method : \nRETURN VALUE=" + obj);  
    	return obj;  
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
