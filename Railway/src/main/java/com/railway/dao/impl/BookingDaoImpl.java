package com.railway.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.railway.bean.Passenger;
import com.railway.dao.BookingDao;

public class BookingDaoImpl implements BookingDao {
	@Autowired
	JdbcTemplate temp;  
	  

	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	@Override
	public int addpassengers(Passenger pass) {
		
		return temp.update(Quries.ADD_USER,pass.getTrainno(),pass.getSeatno(),pass.getName(),pass.getAge(),pass.getGender(),pass.getBerth());
	}

}
