package com.web.apps.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){  
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");  
        Operation e = (Operation) context.getBean("opBean");  
        System.out.println("----------------------->"+e);
        //System.out.println("CCCCCCCCCCCCCCCCCCCCCCC CALLING MSG METHOD DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");  
        //e.msg();  
        
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCC CALLING M METHOD DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");  
        e.m();  
        
        //System.out.println("========calling k...");  
        //e.k();  
    }  
}
