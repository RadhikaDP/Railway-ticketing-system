package com.railway.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.railway.bean.Trains;
import com.railway.dao.TrainsDao;

public class TrainsDaoImpl implements TrainsDao{

	@Autowired
	JdbcTemplate temp;  
	  

	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	@Override
	public List<String> getalldestination() {
		
		return temp.query(Quries.GET_DESTINATION,new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
	           return rs.getString(1);
	              
	        }  
	    });
	}

	@Override
	public List<String> getallsource() {
		return temp.query(Quries.GET_SOURCE,new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
	           return rs.getString(1);
	              
	        }  
	    });
	}
	@Override
	public List<Trains> retriveTrains(String source,String destination) {

		   return temp.query(Quries.TRAINS_BW_STATIONS,new Object[] {source,destination},new RowMapper<Trains>(){  
		        public Trains mapRow(ResultSet rs, int row) throws SQLException {  
		        	Trains e=new Trains();  
		            e.setTrainno(rs.getString(1));  
		            e.setSeats(rs.getInt(3));
		            e.setTrainname(rs.getString(2)); 
		            e.setSource(rs.getString(4));
		            e.setDestination(rs.getString(5));
		            e.setArrival(rs.getString(6));
		            e.setDeparture(rs.getString(7));
		            e.setCapacity(rs.getInt(16));
		            return e;  
		        }  
		    });
	}

}
