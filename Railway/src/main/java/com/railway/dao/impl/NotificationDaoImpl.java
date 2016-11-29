package com.railway.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.railway.bean.Delay;
import com.railway.bean.Passenger;
import com.railway.dao.NotificationDao;

public class NotificationDaoImpl implements NotificationDao{
	@Autowired
	JdbcTemplate temp;  
	  
	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}

	@Override
	public void addDelay(Delay delay) {
		temp.update(Quries.ADD_DELAY,delay.getTrainno(),delay.getTime() );
		
	}

	@Override
	public List<Passenger> getpassengers(String trainno) {
		
			return temp.query(Quries.GET_PASSENGER_BYTRAIN,new Object[] {trainno},new RowMapper<Passenger>(){  
		        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
		        	Passenger e=new Passenger();  

		            e.setTrainno(rs.getString(1));  
		            e.setName(rs.getString(2));
		            e.setAge(rs.getString(3)); 
		            e.setGender(rs.getString(4));
		            e.setBerth(rs.getString(5));
		            e.setUser(rs.getString(6));
		            return e;  
		        }  
		    });
		
	}

	@Override
	public String getmail(String userid) {
		
		return temp.queryForObject(Quries.GET_GMAIL, new Object[] {userid},String.class);
	}
}
