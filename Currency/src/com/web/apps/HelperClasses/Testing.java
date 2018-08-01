package com.web.apps.HelperClasses;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.util.StringUtils;
public class Testing{
	public static void main(String[] args) {
		HashMap<Object,String> map=new HashMap<>();
		System.out.println("map.size===========>"+map.size());
		map.put(1,"one");
		map.put(2,"two");
		map.put(3,"three");
		map.put(4,"four");
		map.put(5,"five");
		map.put(6,"six");
		map.put(7,"seven");
		map.put(8,"eight");
		map.put(9,"nine");
		map.put(10,"ten");
		map.put(11,"eleven");
		map.put(12,"twelve");
		map.put(13,"thirteen");
		map.put(14,"fourteen");
		map.put(15,"fifteen");
		map.put(16,"sixteen");
		map.put(17,"seventeen");
		System.out.println("map.size===========>"+map.size());
		System.err.println("MAP=====>\n"+map);
		
		
		/*System.out.println("Enter Class Name : ");
		createClass(new Scanner(System.in).next());*/
	}
	
	/*public static void createClass(String classname) {
		try {
			Object O = Class.forName("com.web.apps.HelperClasses."+StringUtils.capitalize(classname)).newInstance();
			System.out.println("Object created : "+ O);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
/*
class Car{

}
class Bike{
	
}
class Cycle{
	
}
class Plane{
	
}*/