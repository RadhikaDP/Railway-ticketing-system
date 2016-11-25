package com.railway.controller;

import java.io.IOException;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.railway.service.LoginService;

import com.railway.bean.Registration;



@Controller
public class LoginController {
	private Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	 @RequestMapping(value = "/login",method = RequestMethod.GET)

	    public ModelAndView loginProcess(HttpServletRequest request,HttpServletResponse response,Registration login,HttpSession session) throws IOException{
	    			
	    		ModelAndView model=new ModelAndView("login");
	        	model.addObject("login",login);
	        	logger.info("login model created");	        	
	        	return model;
	    				    	   
	    }
	 
	 @RequestMapping(value="/login",method = RequestMethod.POST)
	    public ModelAndView processLogin(@Valid @ModelAttribute("login") Registration login,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws SQLException {
	    	
	    	if (result.hasErrors()) {
	    		
	    		ModelAndView model=new ModelAndView("login");	
		    	model.addObject("login",login);
		    	return model;
	    	 
	    	}

				boolean islogSuccesful = loginService.ValidateUser(login);
					if(islogSuccesful){
						logger.info("login successfull");
						ModelAndView model=new ModelAndView("redirect:home");	
						return model;
					}
					else{
						logger.info("login failed");
						ModelAndView model=new ModelAndView("redirect:login");	
						
						return model;
					}

	    }
}