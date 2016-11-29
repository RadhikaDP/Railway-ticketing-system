package com.railway.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.railway.bean.Passenger;
import com.railway.bean.Trains;
import com.railway.service.ReportService;
import com.railway.service.TrainsService;

@Controller
public class ReportController {
@Autowired
ReportService reportService;

@Autowired
TrainsService trainservice;

@RequestMapping(value = "/trainreport",method = RequestMethod.GET)

public ModelAndView getreport(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
	ModelAndView model=new ModelAndView("trainreport");	
	return model;
			    	   
}

@RequestMapping(value = "/seniour",method = RequestMethod.GET)

public ModelAndView getseniours(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{
	
	ModelAndView model=new ModelAndView("seniour");	
	return model;
			    	   
}

@RequestMapping(value = "/seniour",method = RequestMethod.POST)

public ModelAndView seniourcitizon(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{
	String trno = trn.getTrainno();
	List<Passenger> pas =reportService.getSReport(trno);
	ModelAndView model=new ModelAndView("viewSeniourReport");	
	model.addObject("pas",pas);
	return model;
			    	   
}

@RequestMapping(value = "/1",method = RequestMethod.GET)

public ModelAndView oneday(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{
	List<String> s = trainservice.getallsource();
	List<String> d = trainservice.getalldestination();
	ModelAndView model=new ModelAndView("1");	
	model.addObject("source",s);
	model.addObject("destination",d);
	return model;
			    	   
}

@RequestMapping(value = "/1",method = RequestMethod.POST)

public ModelAndView gettrains1(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{
	String day = trn.getDay();
	String source = trn.getSource();
	String destination = trn.getDestination();


	List<Trains> trns =reportService.getTrains1(day,source,destination);
	ModelAndView model=new ModelAndView("viewtrains1");	
	model.addObject("trns",trns);

	return model;
			    	   
}

@RequestMapping(value = "/more10",method = RequestMethod.GET)

public ModelAndView getpassenger(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{

	ModelAndView model=new ModelAndView("dalyPassenger");	
	return model;
			    	   
}

@RequestMapping(value = "/more10",method = RequestMethod.POST)

public ModelAndView morethan10(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{

	String trno=trn.getTrainno();
	ModelAndView model=new ModelAndView("viewRegularPass");	
	List<Passenger> pas =reportService.getRegularPass(trno);
	model.addObject("pas",pas);
	return model;
			    	   
}

@RequestMapping(value = "/histReport",method = RequestMethod.GET)

public ModelAndView gethistory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{
	
	ModelAndView model=new ModelAndView("gethistory");	
	return model;
			    	   
}

@RequestMapping(value = "/histReport",method = RequestMethod.POST)

public ModelAndView processhistory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("train") Trains trn) throws IOException{

	String trno=trn.getTrainno();
	ModelAndView model=new ModelAndView("viewRegularPass");	
	List<Passenger> pas =reportService.getTrainHistory(trno);
	model.addObject("pas",pas);
	return model;
			    	   
}

}
