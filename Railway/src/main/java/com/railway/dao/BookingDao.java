package com.railway.dao;


import java.util.Date;
import java.util.List;

import com.railway.bean.Passenger;

public interface BookingDao {
public void addpassengers(String userid,String trainno,String name,String age,String gender,String berth,String date);

public void cancelbooking(String userid, String name);

public void cancelall(String userid);

public void decreaseSeats(int length, String trainno);

public List<Passenger> getcancelations(String userid);

public int deleteOld(Date d1);

public List<Passenger> getbookings(String userid);

public List<Passenger> getPreviousReservation(String userid);

}
