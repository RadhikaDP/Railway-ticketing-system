package com.railway.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.railway.bean.Registration;
import com.railway.dao.LoginDao;

public class LoginDaoImpl implements LoginDao{
	DataSource datasource;
	@Autowired
	JdbcTemplate temp;  
	  
	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
	}
	@Override
	public Registration getLoginDetails(Registration login) {
		
		    return temp.queryForObject(Quries.LOGIN, new Object[]{login.getUserid()},new BeanPropertyRowMapper<Registration>(Registration.class));  
	}

	@Override
	public String getrole(String userid) throws SQLException {

		String GET_ROLEID ="select roleid from userroles where userid ='"+userid+"'";

		PreparedStatement pstmt = datasource.getConnection().prepareStatement(GET_ROLEID);		
		int roleid =0;
		String role = null;
			ResultSet result = pstmt.executeQuery();

			while(result.next()){			
				roleid = result.getInt(1);								
			}
	   String GET_ROLE ="select roles from roles where roleid ='"+roleid+"'";
			 pstmt = datasource.getConnection().prepareStatement(GET_ROLE);
			 result = pstmt.executeQuery();
			while(result.next()){			
				role = result.getString(1);								
			}

		return role;
	}

}
