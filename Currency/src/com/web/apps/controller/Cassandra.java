package com.web.apps.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Cassandra {

	@RequestMapping(value="/getdata")
	public List<?> getdata() {
		
		
		return null;
	}
}
