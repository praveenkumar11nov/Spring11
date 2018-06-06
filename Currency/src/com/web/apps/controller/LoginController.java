package com.web.apps.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.apps.HelperClasses.JavaMailAPI;
import com.web.apps.service.UserService;

@Controller
public class LoginController {
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public String getLoginPage(){
		logger.info("---------------Inside LoginController.getLoginPage()---------------");
/*		String username = ResourceBundle.getBundle("currency").getString("username");
		String password = ResourceBundle.getBundle("currency").getString("password");
		logger.info("username="+username+" password="+password);			*/
		return "login";
	}
	
	@RequestMapping(value="/forgotpwd")
	public String getPassword(HttpServletRequest request,Model model) throws AddressException, MessagingException{
		logger.info("---------------Inside LoginController.getPassword()---------------");
		String email=request.getParameter("Username");
		System.err.println("email="+email);
		logger.info("Forgot Password Page........");
		int send=JavaMailAPI.sendEmail(email,"CurrencyLogin<Password>","Your Password is 123");
		if(send==0){
			model.addAttribute("msg","Password sent to "+email);
		}else{
			model.addAttribute("msg","Error While Sending Password to "+email);
		}
		return "login";
	}
	
	@RequestMapping(value="/successPage",method={RequestMethod.GET,RequestMethod.POST})
	public String getSuccessPage(HttpServletRequest request){
		logger.info("---------------Inside LoginController.getSuccessPage()---------------");
		if(request.getParameter("Username")==null){
			logger.info("UserName is null | Redirecting to login page");
			return "login";
		}else{
			int validate=userService.validate(request.getParameter("Username"),request.getParameter("Password"));
			if(validate==0){
				logger.info("user name not found!");
				return "login";
			}else{
				logger.info("Name="+request.getParameter("Username")+" Password="+request.getParameter("Password"));
				HttpSession session=request.getSession(false);
				session.setAttribute("name",request.getParameter("Username"));
				return "homepage";
			}
		}
	}
	
	@RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})
	public String getLoggedOut(HttpServletRequest request){
		logger.info("---------------Inside LoginController.getLoggedOut()---------------");
		HttpSession session=request.getSession(false);
		session.removeAttribute("name");
		return "login";
	}
	
	@Scheduled(cron="${scheduling.job.testcron}")
	public void cronTest(){
		for(int i=1;i<6;i++){
			System.out.println("CRON TESTING : " + i);
		}
	}
}