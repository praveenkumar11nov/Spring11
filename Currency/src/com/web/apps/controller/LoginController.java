package com.web.apps.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.apps.HelperClasses.JavaMailAPI;
import com.web.apps.model.Employee;
import com.web.apps.model.UserRole;
import com.web.apps.model.Users;
import com.web.apps.service.RoleService;
import com.web.apps.service.UserService;

@Controller
public class LoginController {
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value= {"/","/login"})
	public String getLoginPage(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout){
		//logger.info("Inside LoginController.getLoginPage()____________________");
/*		String username = ResourceBundle.getBundle("currency").getString("username");
		String password = ResourceBundle.getBundle("currency").getString("password");		*/
		
		ModelAndView model = new ModelAndView();
		//System.err.println("error ========> " + error);
		//System.err.println("logout ========> " + logout);
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		return "login";
	}
	
	@RequestMapping(value= "/registerUsers")
	public String registerTheUSer(HttpServletRequest request,Model model){
		//logger.info("Inside LoginController.registerTheUSer()____________________");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		String retypedpwd = request.getParameter("retypepwd");
		
		if(pwd.equalsIgnoreCase(retypedpwd)){
			Users user = new Users();
			user.setUSERNAME(username);
			user.setPASSWORD(pwd);
			user.setENABLED("1");
			user.setCREATEDDATE(new Date());
			user.setCREATEDBY(username);
			user.setEMAIL(email);
			try{
				userService.save(user);
				/*try{
					UserRole role=new UserRole();
					role.setUSERNAME(username);
					role.setROLE("USER");
					roleService.save(role);
					model.addAttribute("msg","User is registered Successfully !");
				}catch(Exception e){
					logger.info("Exception came while creating role for user : " + e.getMessage());
					model.addAttribute("msg","Error while creating role for user !");
				}*/
				
			}catch(Exception e){
				logger.info("Exception While Saving User : " + e.getMessage());
				model.addAttribute("msg","Username Already Exists");
			}
		}else{
			model.addAttribute("msg","User password is not matched !");
		}
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
	public String getSuccessPage(Authentication authentication,HttpServletRequest request){
		logger.info("Inside LoginController.getSuccessPage()____________________");
		//System.err.println("USERNAME ======== " + authentication.getName());
		HttpSession session=request.getSession(false);
		session.setAttribute("name",authentication.getName());
		return "homepage";
	}
	
	@RequestMapping(value="/dashboard",method={RequestMethod.POST})
	public String getSuccessPageAfterLoginFromGoogle(HttpServletRequest request){
		logger.info("Inside LoginController.dashboard()____________________");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String imagurl = request.getParameter("imagurl");
		
		System.err.println("Response received from GOOGLE\nname="+name+",\nemail="+email+",\nimagurl="+imagurl);
		
		HttpSession session=request.getSession(false);
		session.setAttribute("name",name);
		return "homepage";
	}
	
	@RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})
	public String getLoggedOut(HttpServletRequest request){
		logger.info("Inside LoginController.getLoggedOut()____________________");
		try{
			HttpSession session=request.getSession(false);
			session.removeAttribute("name");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "login";
	}
	
	//@Scheduled(cron="${scheduling.job.testcron}")
	public void cronTest(){
		for(int i=1;i<6;i++){
			System.out.println("CRON TESTING : " + i);
		}
	}
	
	@RequestMapping(value="/api/empdetails",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getEmployeeDeatils(){
		/*List<Employee> list=new ArrayList<>();
		list.add(new Employee("RAM","BCITS","DEVELOPER"));
		list.add(new Employee("ANJUM","BCITS","DEVELOPER"));
		list.add(new Employee("SACHIN","BCITS","DEVELOPER"));
		list.add(new Employee("VEMA","BCITS","DEVELOPER"));
		System.out.println(list);*/
		return "Websrvice called........";
	}
}