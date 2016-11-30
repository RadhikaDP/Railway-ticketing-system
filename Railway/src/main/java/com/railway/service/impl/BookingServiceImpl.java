package com.railway.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Passenger;
import com.railway.dao.BookingDao;
import com.railway.service.BookingService;

public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao bookdao;
	

	@Override
	public void addpassengers(Passenger pass,String userid,String trainno,String date) {
		
		String name[]=pass.getName().split(",");
		String age[]=pass.getAge().split(",");
		String gender[] = pass.getGender().split(",");
		String berth[]=pass.getBerth().split(",");	
		int length =name.length;
		for(int i=0;i<name.length;i++){
		bookdao.addpassengers(userid,trainno,name[i],age[i],gender[i],berth[i],date);
		}
		decreaseseats(length,trainno);
	}
	@Override
	public List<Passenger> getbookings(String userid) {
		String a = new Date().toString();
		System.out.println(a);
		String dateStr = a;
		try{
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date dates = (Date)formatter.parse(dateStr);
		System.out.println(dates);        

		Calendar cal = Calendar.getInstance();
		cal.setTime(dates);
		String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
		System.out.println("formatedDate : " + formatedDate);   
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 =sdf.parse(formatedDate);
		System.out.println(a);
		bookdao.deleteOld(d1);
		return bookdao.getbookings(userid);
		}
		catch(Exception e){
			System.out.println(e);
		}
	return null;	
	}
	@Override
	public void cancelbookings(String userid, String name) {
		bookdao.cancelbooking(userid,name);
		
	}
	@Override
	public void cancelall(String userid) {
		bookdao.cancelall(userid);
		
	}
	
	public void decreaseseats(int length,String trainno){
		bookdao.decreaseSeats(length,trainno);
	}
	@Override
	public List<Passenger> getcancelations(String userid) {
		
		return bookdao.getcancelations(userid);
	}
	@Override
	public List<Passenger> getPreviousReservation(String userid) {
		return bookdao.getPreviousReservation(userid);
	}


}
