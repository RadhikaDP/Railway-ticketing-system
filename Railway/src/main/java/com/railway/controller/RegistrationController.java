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

import com.railway.bean.Registration;
import com.railway.service.RegistrationService;

@Controller
public class RegistrationController {
	
	private Logger logger=Logger.getLogger(RegistrationController.class);
	
	@Autowired
	private RegistrationService regService;
	
	 @RequestMapping(value = "/registration",method = RequestMethod.GET)

	    public ModelAndView registrationProcess(HttpServletRequest request,HttpServletResponse response,Registration reg,HttpSession session) throws IOException{
	    			
	    		ModelAndView model=new ModelAndView("registration");
	        	model.addObject("reg",reg);
	        	logger.info("registration model created");	        	
	        	return model;
	    				    	   
	    }
	 
	 @RequestMapping(value="/registration", method = RequestMethod.POST )
	 
	    public ModelAndView doregistration(@Valid @ModelAttribute("registration") Registration reg,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws SQLException {
	    	if (result.hasErrors()) {
	    		
	    		ModelAndView model=new ModelAndView("registration");	
		    	model.addObject("reg",reg);
		    	return model;
	    	 
	    	}
	    	int i=regService.adduser(reg);
	    	if(i==1){
	    		logger.info("registration successful");
	    		ModelAndView model=new ModelAndView("redirect:login");	
	    		return model;
	    	}
	    	logger.info("registration unsuccessfull");
	    	ModelAndView model=new ModelAndView("redirect:registration");	
	    	return model;
	 }
}
