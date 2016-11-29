package com.railway.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
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
	public void addpassengers(String userid,String trainno,String name,String age,String gender,String berth) {
	
		temp.update(Quries.ADD_Passengers,trainno,name,age,gender,berth,userid);
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
	            e.setBookingid(rs.getString(6));
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

}
