package com.railway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Passenger;
import com.railway.bean.Trains;
import com.railway.dao.ReportDao;
import com.railway.service.ReportService;

public class ReportServiceImpl implements ReportService {
	@Autowired
	ReportDao reportdao;

	@Override
	public List<Passenger> getSReport(String trno) {
		
		return reportdao.getSReport(trno);
	}

	@Override
	public List<Trains> getTrains1(String trno, String source,String destination) {
		return reportdao.getTrains1(trno,source,destination);
	}

	@Override
	public List<Passenger> getRegularPass(String trno) {
		
		return reportdao.getRegularPass(trno);
	}

	@Override
	public List<Passenger> getTrainHistory(String trno) {
	
		return reportdao.getTrainHistory(trno);
	}
}
