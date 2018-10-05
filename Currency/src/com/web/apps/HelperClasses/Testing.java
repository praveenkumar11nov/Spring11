package com.web.apps.HelperClasses;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.util.StringUtils;
public class Testing{
	
	public static void main(String[] args){
		Integer i = new Integer(12); 
		System.out.println(i); 
		modify(i); 
		System.out.println(i); 
	}

	private static void modify(Integer i){ 
		i = i + 1; 
	} 
	  
}