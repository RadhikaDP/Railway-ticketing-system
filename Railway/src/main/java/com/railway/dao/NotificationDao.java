package com.railway.dao;

import java.util.List;

import com.railway.bean.Delay;
import com.railway.bean.Passenger;

public interface NotificationDao {

	void addDelay(Delay delay);

	List<Passenger> getpassengers(String trainno);

	String getmail(String userid);

}
