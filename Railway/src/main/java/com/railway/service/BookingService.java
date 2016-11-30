package com.railway.service;

import java.util.Date;
import java.util.List;

import com.railway.bean.Passenger;

public interface BookingService {
	public void addpassengers(Passenger pass,String userid,String trainno,String date);

	public List<Passenger> getbookings(String userid);

	public void cancelbookings(String userid, String name);

	public void cancelall(String userid);

	public List<Passenger> getcancelations(String userid);

	public List<Passenger> getPreviousReservation(String userid);
}
