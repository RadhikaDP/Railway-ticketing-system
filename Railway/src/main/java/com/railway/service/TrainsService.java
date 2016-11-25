package com.railway.service;

import java.util.List;

import com.railway.bean.Trains;



public interface TrainsService {

	public List<String> getalldestination();

	public List<String> getallsource();
	
	public List<Trains> retriveTrains(String source,String destination);

}
