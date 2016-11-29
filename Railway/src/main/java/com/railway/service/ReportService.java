package com.railway.service;

import java.util.List;

import com.railway.bean.Passenger;
import com.railway.bean.Trains;

public interface ReportService {

	List<Passenger> getSReport(String trno);

	List<Trains> getTrains1(String trno, String source, String destination);

	List<Passenger> getRegularPass(String trno);

	List<Passenger> getTrainHistory(String trno);

}
