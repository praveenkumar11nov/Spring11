package com.web.apps.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackOperation {
	
    @Pointcut("execution(* Operation.*(..))")  
    public void k(){}//pointcut name  
      
    @Before("k()")//applying pointcut on before advice  
    public void myadvice1(JoinPoint jp){System.out.println("additional concern BEFORE");  
        //System.out.println("Method Signature: "  + jp.getSignature());  
    }  

    @After("k()")
    public void myadvice2() {System.out.println("after executing advice");}
    
    @Before("execution(* Operation.*(..))")
    public void myadvice3(JoinPoint jp){System.out.println("==================additional concern before");}
    
    
    @Pointcut("execution(* Operation.*(..))")  
    public void abcPointcut(){}  
      
    @Around("abcPointcut()")  
    public Object myadvice4(ProceedingJoinPoint pjp) throws Throwable{  
        System.out.println("Additional Concern Before calling actual method");  
        Object obj=pjp.proceed();  
        System.out.println("Additional Concern After calling actual method : RETURN VALUE=" + obj);  
        return obj;  
    }  
}
