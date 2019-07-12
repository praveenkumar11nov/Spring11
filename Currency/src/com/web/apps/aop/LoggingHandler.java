package com.web.apps.aop;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String usernameForApi = ResourceBundle.getBundle("configuration").getString("APIUSERNAME");
	public static final String passwordForApi = ResourceBundle.getBundle("configuration").getString("APIPASSWORD");

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void allMethod() {
	}

	@Pointcut("execution(public * *(..))")
	protected void loggingPublicOperation() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void loggingAllOperation() {
	}

	@Pointcut("within(com.web.apps.controller..*)")
	private void logAnyFunctionWithinResource() {
	}

	
	//==============================================================//
	String authPAthForMethod="NA";
	String usernameInAPI="NA";
	String passwordInAPI="NA";
	//==============================================================//
	
	//before -> Any resource annotated with @Controller annotation //and all method and function taking HttpServletRequest as first parameter
	@Before("controller() && allMethod() && args(..,request)")
	public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&& LOG BEFORE CONTROLLER &&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		authPAthForMethod = request.getServletPath();
		
		System.out.println("Method Type : " + request.getMethod());
		System.out.println("Entering in Method :  " + joinPoint.getSignature().getName());
		System.out.println("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		System.out.println("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Target class : " + joinPoint.getTarget().getClass().getName());

		if (null != request) {
			System.out.println("start header section of request ");
			System.out.println("method type : " + request.getMethod());

			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				String headerValue = request.getHeader(headerName);
				System.out.println("Header Name: " + headerName + " Header Value : " + headerValue);
				//==============================================================//
				if(headerName.equalsIgnoreCase("username")) {
					//System.err.println("username in api : " + headerValue);
					usernameInAPI=headerValue;					
				}
				if(headerName.equalsIgnoreCase("password")) {
					//System.err.println("username in api : " + headerValue);
					passwordInAPI=headerValue;					
				}
				//==============================================================//
			}
			System.out.println("Request Path info :" + request.getServletPath());
			System.out.println("End Header Section of request ");
		}
	}
	
	//After -> All method within resource annotated with @Controller annotation  // and return a  value
	@AfterReturning(pointcut = "controller() && allMethod()", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		String returnValue = this.getValue(result);
		System.out.println("Method Return value : " + returnValue);
	}
	
	//After -> Any method within resource annotated with @Controller annotation  // throws an exception ...Log it
	@AfterThrowing(pointcut = "controller() && allMethod()", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
		System.out.println("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
		System.out.println("Cause : " + exception.getCause());
	}
	
	//Around -> Any method within resource annotated with @Controller annotation 
	@Around("controller() && allMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result;
			//==============================================================//
			if(authPAthForMethod.startsWith("/getData/")) {
				//System.err.println("usernameInAPI="+usernameInAPI+" passwordInAPI:"+passwordInAPI);
				if(usernameInAPI.equalsIgnoreCase(usernameForApi) && passwordInAPI.equalsIgnoreCase(passwordForApi)) {
					result = joinPoint.proceed();	
				}else {
					result = new JSONObject().put("ERROR","YOU ARE NOT AUTHORISED PERSON. TRY WITH CORRECT USERNAME AND PASSWORD").toString();	
				}
			}else {
				result = joinPoint.proceed();				
			}
			//==============================================================//
			//Object result= joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			System.out.println("Method " + className + "." + methodName + " ()" + " execution time : " + elapsedTime + " ms");
			
			usernameInAPI="NA";
			passwordInAPI="NA";
			authPAthForMethod="NA";
			return result;
		} 
		catch (IllegalArgumentException e) {
			System.out.println("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in " + joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
	
	private String getValue(Object result) {
		String returnValue = null;
		if (null != result) {
			if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
				returnValue = ReflectionToStringBuilder.toString(result);
			} else {
				returnValue = result.toString();
			}
		}
		return returnValue;
	}
	
	
}
