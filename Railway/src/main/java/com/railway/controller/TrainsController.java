package com.railway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.railway.bean.Trains;
import com.railway.service.TrainsService;

@Controller
public class TrainsController {
	private Logger logger=Logger.getLogger(TrainsController.class);
	
	@Autowired
	TrainsService trainservice;
	
	@RequestMapping(value = "/viewtrains",method = RequestMethod.GET)
    public ModelAndView trains(HttpServletRequest request,HttpServletResponse response,@Valid @ModelAttribute("trains")Trains train) throws IOException{
    			
    		ModelAndView model=new ModelAndView("viewtrains");
    		List<String> source = trainservice.getallsource();
    		List<String> destination = trainservice.getalldestination();
        	model.addObject("train",train);
        	model.addObject("source",source);
        	model.addObject("destination",destination);
        	logger.info("view trains model created");	        	
        	return model;
    				    	   
    }
	
	@RequestMapping(value = "/viewtrains",method = RequestMethod.POST)
	
	  public ModelAndView viewtrains(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("trains")Trains train) throws IOException{
		ModelAndView model=new ModelAndView("viewtains");
		
		List<Trains> trains = trainservice.retriveTrains(train.getSource(),train.getDestination());
		model.addObject("train",trains);
		return model;
	}
}
