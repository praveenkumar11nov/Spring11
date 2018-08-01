package com.web.apps.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Aspect
public class PrimaryAspects {
	
	@Before("execution(public String getResponse())")
    public void myadvice(){
        System.out.println("WEBService Called....");  
    }
}
