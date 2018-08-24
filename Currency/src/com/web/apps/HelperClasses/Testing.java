package com.web.apps.HelperClasses;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.util.StringUtils;
public class Testing{
	public static void main(String[] args) {
		String text="Page+closed+by+Customer+%28after+page+load%29";
		text=text.replace("+"," ");
		text=text.replace("%","");
		text=text.replace("2"," ");
		text=text.replace("9"," ");
		text=text.replace("8"," ");
		System.out.println(text);
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