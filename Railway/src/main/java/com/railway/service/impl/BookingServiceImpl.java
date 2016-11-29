package com.railway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Passenger;
import com.railway.dao.BookingDao;
import com.railway.service.BookingService;

public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookdao;
	

	@Override
	public void addpassengers(Passenger pass,String userid,String trainno) {
		String name[]=pass.getName().split(",");
		String age[]=pass.getAge().split(",");
		String gender[] = pass.getGender().split(",");
		String berth[]=pass.getBerth().split(",");	
		int length =name.length;
		for(int i=0;i<name.length;i++){
		bookdao.addpassengers(userid,trainno,name[i],age[i],gender[i],berth[i]);
		}
		decreaseseats(length,trainno);
	}
	@Override
	public List<Passenger> getbookings(String userid) {
		
		return bookdao.getbookings(userid);
	}
	@Override
	public void cancelbookings(String userid, String name) {
		bookdao.cancelbooking(userid,name);
		//bookdao.insertHistory(userid,name);
	}
	@Override
	public void cancelall(String userid) {
		bookdao.cancelall(userid);
		
	}
	
	public void decreaseseats(int length,String trainno){
		bookdao.decreaseSeats(length,trainno);
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
}
