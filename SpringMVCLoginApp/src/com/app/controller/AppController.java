package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.UserRegistration;
import com.app.service.UserService;

@Controller
@RequestMapping("/app")
public class AppController {
	
	
	@Autowired
	private UserService userService;
	
	
	
@RequestMapping("/signup")
public ModelAndView userSignUp()
{
	return new ModelAndView("signup","command", new UserRegistration());
}
@RequestMapping(value="/savesignup", method = RequestMethod.POST)
public String signUp(@ModelAttribute("SpringWeb")UserRegistration userregistration, 
		   ModelMap model,HttpServletRequest request)
{
	int count=userService.register(userregistration);
	model.addAttribute("name", userregistration.getName());
	model.addAttribute("mail", userregistration.getMail());
	model.addAttribute("password", userregistration.getPassword());
	model.addAttribute("repassword", userregistration.getRepassword());
	model.addAttribute("contact", userregistration.getContact());
	
	if(count>0)
	return "success";
	else
		return "signup";
}
	@RequestMapping("login")
	public ModelAndView login()
	{
		return new ModelAndView("login");
	}
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request)
	{
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
	    boolean result=	userService.login(mail,password);
	    if(result==true)
	    	return "success";
	    	else
	    		return "login";
	}
	@RequestMapping("allUser")
	public ModelAndView allUser()
	{
		 List<UserRegistration> allUserData=userService.allUser();
		return new ModelAndView("allUser","allUserData",allUserData);
	}

}
