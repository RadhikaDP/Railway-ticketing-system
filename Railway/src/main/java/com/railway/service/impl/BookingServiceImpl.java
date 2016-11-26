package com.railway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Passenger;
import com.railway.dao.BookingDao;
import com.railway.service.BookingService;

public class BookingServiceImpl implements BookingService {
	@Autowired
BookingDao bookdao;
	@Override
	public int addpassengers(Passenger pass) {

		return bookdao.addpassengers(pass);
	}

}
