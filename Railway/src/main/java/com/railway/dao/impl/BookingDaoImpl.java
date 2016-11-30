package com.railway.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.railway.bean.Passenger;
import com.railway.dao.BookingDao;

public class BookingDaoImpl implements BookingDao {
	@Autowired
	JdbcTemplate temp;  
	  

	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	@Override
	public void addpassengers(String userid,String trainno,String name,String age,String gender,String berth,String date) {
		String dateStr = date;
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
		temp.update(Quries.ADD_Passengers,trainno,name,age,gender,berth,userid,d1);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	@Override
	public List<Passenger> getbookings(String userid) {

		return temp.query(Quries.GET_BOOKINGS,new Object[] {userid},new RowMapper<Passenger>(){  
	        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
	        	Passenger e=new Passenger();  

	            e.setTrainno(rs.getString(1));  
	            e.setName(rs.getString(2));
	            e.setAge(rs.getString(3)); 
	            e.setGender(rs.getString(4));
	            e.setBerth(rs.getString(5));
	            e.setBookingid(rs.getString(7));
	            e.setTravelDate(rs.getDate(8));
	            return e;  
	        }  
	    });
	}
	@Override
	public void cancelbooking(String userid, String name) {
		
		temp.update(Quries.CANCEL,new Object[]{userid,name});
		
	}

	@Override
	public void cancelall(String userid) {
		temp.update(Quries.CANCEL_ALL, new Object[]{userid});
		
	}
	@Override
	public void decreaseSeats(int length,String trainno) {
		temp.update(Quries.DECREASE_SEATS,new Object[]{length,trainno});
	}
	@Override
	public List<Passenger> getcancelations(String userid) {
		
		 return temp.query(Quries.GET_CANCELATION,new Object[] {userid},new RowMapper<Passenger>(){  
	        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
	        	Passenger e=new Passenger();  

	            e.setTrainno(rs.getString(1));  
	            e.setName(rs.getString(2));
	            e.setAge(rs.getString(3)); 
	            e.setGender(rs.getString(4));
	            e.setBerth(rs.getString(5));
	            e.setBookingid(rs.getString(7));
	            e.setTravelDate(rs.getDate(8));
	            return e;  
	        }  
	    });
	}
	@Override
	public int deleteOld(Date d1) {
		return temp.update(Quries.DELETE_OLD,new Object[] {d1});
		
		
	}
	@Override
	public List<Passenger> getPreviousReservation(String userid) {
		return temp.query(Quries.GET_RES_HIST,new Object[] {userid},new RowMapper<Passenger>(){  
	        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
	        	Passenger e=new Passenger();  

	            e.setTrainno(rs.getString(1));  
	            e.setName(rs.getString(2));
	            e.setAge(rs.getString(3)); 
	            e.setGender(rs.getString(4));
	            e.setBerth(rs.getString(5));
	            e.setBookingid(rs.getString(7));
	            e.setTravelDate(rs.getDate(8));
	            return e;  
	        }  
	    });
	}


}
