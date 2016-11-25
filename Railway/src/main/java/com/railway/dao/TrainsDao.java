package com.railway.dao;

import java.util.List;

import com.railway.bean.Trains;

public interface TrainsDao {

	List<String> getalldestination();

	List<String> getallsource();
	
	List<Trains> retriveTrains(String source,String destination);

}
