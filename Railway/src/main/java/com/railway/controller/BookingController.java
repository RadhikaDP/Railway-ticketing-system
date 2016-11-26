package com.railway.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.railway.bean.Passenger;
import com.railway.bean.Trains;
import com.railway.service.BookingService;
import com.railway.service.TrainsService;

@Controller
public class BookingController {
	private Logger logger=Logger.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingservice;
	
	@RequestMapping(value = "/booking/{trainno}",method = RequestMethod.GET)
    public ModelAndView getbookingform(HttpServletRequest request,HttpServletResponse response,Trains train,@ModelAttribute("passenger") Passenger pass) throws IOException{
    			
    		ModelAndView model=new ModelAndView("booking");      	
        	return model;
    				    	   
    }
	@RequestMapping(value = "/booking/{trainno}",method = RequestMethod.POST)
    public ModelAndView insertpassenger(HttpServletRequest request,HttpServletResponse response,Trains train,@ModelAttribute("passenger") Passenger pass) throws IOException{
    			
		
		
    		ModelAndView model=new ModelAndView("bookconfirm");    
        	return model; 				    	   
    }
}
