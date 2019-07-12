package com.web.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value="/sum",method= RequestMethod.GET)
	public double sum(double a,double b) {
		System.out.println("ADDING TWO NUMBERS " + a + " AND " + b);
		return a+b;
	}
	
	/*
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ResponseEntity validate(@RequestBody String userString) {
        Map<String, String> user = new Gson().fromJson(userString, Map.class);
		userService.validateUser(user);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> userDetails() {
        
		List<UserDetails> userDetails = userService.getUserDetails();
		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
	}
	*/

}
