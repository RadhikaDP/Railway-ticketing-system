package com.railway.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.railway.bean.Delay;
import com.railway.service.NotificationService;


@Controller
public class NotificationController {
	
	private Logger logger=Logger.getLogger(NotificationController.class);
	
	@Autowired
	NotificationService notService;
	
	 @RequestMapping(value = "/delay",method = RequestMethod.GET)

	    public ModelAndView getdelay(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("delay") Delay delay,HttpSession session) throws IOException{
	    			
	    		ModelAndView model=new ModelAndView("delay");
	        	logger.info("delay model created");	        
	        	model.addObject(delay);
	        	return model;
	    				    	   
	    }
	 
	 @RequestMapping(value = "/delay",method = RequestMethod.POST)

	    public ModelAndView sendnotification(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("delay") Delay delay,HttpSession session) throws IOException{
	    			
	    		ModelAndView model=new ModelAndView("delaysuccess");
	    		notService.addDelay(delay);
	        	model.addObject(delay);
	        	return model;
	        	
	    }
}
