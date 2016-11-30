package com.railway.dao.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.railway.bean.Passenger;
import com.railway.bean.Trains;
import com.railway.dao.ReportDao;

public class ReportDaoImpl implements ReportDao {
	@Autowired
	JdbcTemplate temp;  
	  
	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}

	@Override
	public List<Passenger> getSReport(String trno) {
		
		return temp.query(Quries.GET_SENIOURS,new Object[] {trno},new RowMapper<Passenger>(){  
	        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
	        	Passenger e=new Passenger();  
	            e.setName(rs.getString(1));
	            e.setAge(rs.getString(2)); 
	            e.setGender(rs.getString(3));
	            return e;  
	        }  
	    });
	}

	@Override
	public List<Trains> getTrains1(String day, String source,String destination) {
		String sql="select * from train where train.source='"+source+"' and train.destination='"+destination+"' and train.trainno in(select TRAVELDAYS.trainno from TRAVELDAYS where "+day+"= 'Y')";
	   return temp.query(sql,new RowMapper<Trains>(){  
		        public Trains mapRow(ResultSet rs, int row) throws SQLException {  
		        	
		        	Trains e=new Trains();  		        	
		            e.setTrainno(rs.getString(1));  
		            e.setTrainname(rs.getString(2)); 
		            e.setSource(rs.getString(4));
		            e.setDestination(rs.getString(5));
		            e.setArrival(rs.getString(6));
		            e.setDeparture(rs.getString(7));		           
		            return e;  
		        }  
		    });
	
	}

	@Override
	public List<Passenger> getRegularPass(String trno) {
		
		return temp.query(Quries.GET_REG_PASS,new Object[] {trno},new RowMapper<Passenger>(){  
	        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
	        	Passenger e=new Passenger();  
	            e.setName(rs.getString(1));
	            e.setAge(rs.getString(2)); 
	            e.setGender(rs.getString(3));

	            return e;  
	            
	        }  
	    });
	}

	@Override
	public List<Passenger> getTrainHistory(String trno) {
		
		return temp.query(Quries.GET_ALL_PASS,new Object[] {trno},new RowMapper<Passenger>(){  
	        public Passenger mapRow(ResultSet rs, int row) throws SQLException {  
	        	Passenger e=new Passenger();  


	            e.setName(rs.getString(1));
	            e.setAge(rs.getString(2)); 
	            e.setGender(rs.getString(3));

	            return e;  
	            
	        }  
	    });
	}

	@Override
	public List<Trains> getTrains2(String day1, String day2, String source, String destination) {
		String sql="select * from train where train.source='"+source+"' and train.destination='"+destination+"' and train.trainno in(select TRAVELDAYS.trainno from TRAVELDAYS where "+day1+"= 'Y'and +"+day2+"='Y')";
		   return temp.query(sql,new RowMapper<Trains>(){  
			        public Trains mapRow(ResultSet rs, int row) throws SQLException {  
			        	
			        	Trains e=new Trains();  		        	
			            e.setTrainno(rs.getString(1));  
			            e.setTrainname(rs.getString(2)); 
			            e.setSource(rs.getString(4));
			            e.setDestination(rs.getString(5));
			            e.setArrival(rs.getString(6));
			            e.setDeparture(rs.getString(7));		           
			            return e;  
			        }  
			    });
	}
}
