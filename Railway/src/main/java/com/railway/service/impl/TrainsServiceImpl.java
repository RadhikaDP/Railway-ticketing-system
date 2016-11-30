package com.railway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Trains;
import com.railway.dao.TrainsDao;
import com.railway.service.TrainsService;

public class TrainsServiceImpl implements TrainsService{

	@Autowired
	TrainsDao trainsdao;
	@Override
	public List<String> getalldestination() {
		
		return trainsdao.getalldestination();
	}

	@Override
	public List<String> getallsource() {
		return trainsdao.getallsource();
	}


	@Override
	public List<String> gettrainno(String week) {
		
		return trainsdao.gettrainno(week);
	}

	@Override
	public List<Trains> retriveTrains(String source, String destination,String week) {

		return trainsdao.retriveTrains(source,destination,week);

	}
}
