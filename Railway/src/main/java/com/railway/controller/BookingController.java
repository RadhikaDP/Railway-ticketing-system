package com.railway.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.railway.bean.Passenger;
import com.railway.bean.Trains;
import com.railway.service.BookingService;

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
    public ModelAndView insertpassenger(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("passenger" ) Passenger pass,@PathVariable String trainno,HttpSession session) throws IOException{

			String userid=(String)session.getAttribute("userid");
			String date = (String)session.getAttribute("date");
			bookingservice.addpassengers(pass,userid,trainno,date);
    		ModelAndView model=new ModelAndView("bookconfirm");    
        	return model; 				    	   
    }
	
	@RequestMapping(value = "/viewbooking",method = RequestMethod.GET)
    public ModelAndView viewbooking(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
    		
			String userid=(String)session.getAttribute("userid");
			List<Passenger> pass=bookingservice.getbookings(userid);
    		ModelAndView model=new ModelAndView("viewbooking");      	
    		model.addObject("pass",pass);
        	return model;
    				    	   
    }
	
	@RequestMapping(value = "/viewcancelation",method = RequestMethod.GET)
    public ModelAndView viewcancellation(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
    		
			String userid=(String)session.getAttribute("userid");
			List<Passenger> pass=bookingservice.getcancelations(userid);
    		ModelAndView model=new ModelAndView("viewReservationHist");      	
    		model.addObject("pass",pass);
        	return model;
    				    	   
    }
	
	@RequestMapping(value = "/cancel/{name}",method = RequestMethod.GET)
    public ModelAndView cancelbooking(HttpServletRequest request,HttpServletResponse response,HttpSession session,@PathVariable String name) throws IOException{
    		
			String userid=(String)session.getAttribute("userid");
			bookingservice.cancelbookings(userid,name);
			return new ModelAndView("redirect:/viewbooking");
    				    	   
    }
	
	@RequestMapping(value = "/cancelall",method = RequestMethod.GET)
    public ModelAndView cancelall(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
    		
			String userid=(String)session.getAttribute("userid");
			bookingservice.cancelall(userid);
			return new ModelAndView("redirect:/home");
    				    	   
    }
	
	@RequestMapping(value = "/viewresHist",method = RequestMethod.GET)
    public ModelAndView viewPreviousHist(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		String userid=(String)session.getAttribute("userid");
		List<Passenger> pass=bookingservice.getPreviousReservation(userid);
    		ModelAndView model=new ModelAndView("viewReservationHist");      	
    		model.addObject("pass",pass);
        	return model;
    				    	   
    }
}
