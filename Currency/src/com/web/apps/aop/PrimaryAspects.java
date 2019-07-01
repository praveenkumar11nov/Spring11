package com.web.apps.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//@EnableAspectJAutoProxy
@Aspect
@Component
public class PrimaryAspects {
	/*
	@Before("execution(* com.web.apps.HelperClasses.WebServices.*(..))")
	public void myadvice(){
        System.out.println("WEBService Called....");  
    }
	
	@After("execution(* com.web.apps.controller.LoginController.getSuccessPage(..))")
	public void myadvice2(){
		System.out.println("USER LOGGED" );  
	}

    @Pointcut("execution(* com.web.apps.HelperClasses.WebServices.*(..))")  
    public void abcPointcut(){}  
      
    @Around("abcPointcut()")  
    public Object myadvice4(ProceedingJoinPoint pjp) throws Throwable{  
        System.out.println("Additional Concern Before calling actual method");  
        Object obj=pjp.proceed();  
        System.out.println("Additional Concern After calling actual method : \nRETURN VALUE=" + obj);  
        return obj;  
    } 
    */
}
