package com.railway.service;

import java.util.List;

import com.railway.bean.Passenger;

public interface BookingService {
	public void addpassengers(Passenger pass,String userid,String trainno);

	public List<Passenger> getbookings(String userid);

	public void cancelbookings(String userid, String name);

	public void cancelall(String userid);
}
