package com.railway.dao.impl;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.railway.bean.Trains;
import com.railway.dao.TrainsDao;

public class TrainsDaoImpl implements TrainsDao{
	DataSource datasource;
	@Autowired
	private JdbcTemplate temp;  
	  

	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
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
	public List<Trains> retriveTrains(String source,String destination,String week) {

		String sql="select * from train where train.source='"+source+"' and train.destination='"+destination+"' and train.trainno in(select TRAVELDAYS.trainno from TRAVELDAYS where "+week+"= 'Y')";

		
		return temp.query(sql,new RowMapper<Trains>(){  
	        public Trains mapRow(ResultSet rs, int row) throws SQLException {  
	        	Trains t=new Trains();  

	        	t.setTrainno(rs.getString(1));  
	            t.setTrainname(rs.getString(2)); 
	            t.setSeats(rs.getInt(3));
	            t.setSource(rs.getString(4));
	            t.setDestination(rs.getString(5));
	            t.setArrival(rs.getString(6));
	            t.setDeparture(rs.getString(7));
	            t.setDistance(rs.getFloat(8));
	            t.setCapacity(rs.getInt(9));
	            return t;  
	        }  
	    });
	}
	@Override
	public List<String> gettrainno(String week) {
		String query="select trainno from days where "+week+"='Y'";
		
		return temp.query(query,new RowMapper<String>(){  
	        public String mapRow(ResultSet rs, int row) throws SQLException {  	            
		           return rs.getString(1);
		              
		        }  
		    });
	}

}
