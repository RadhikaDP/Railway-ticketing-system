package com.railway.dao;

import java.util.List;

import com.railway.bean.Passenger;

public interface BookingDao {
public void addpassengers(String userid,String trainno,String name,String age,String gender,String berth);

public List<Passenger> getbookings(String userid);

public void cancelbooking(String userid, String name);

public void cancelall(String userid);

public void decreaseSeats(int length, String trainno);

//public void insertHistory(String userid, String name);
}
