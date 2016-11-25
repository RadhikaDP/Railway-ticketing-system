package com.railway.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.railway.bean.Login;
import com.railway.bean.Registration;
import com.railway.dao.LoginDao;

public class LoginDaoImpl implements LoginDao{

	@Autowired
	JdbcTemplate temp;  
	  
	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	
	@Override
	public Registration getLoginDetails(Registration login) {
		// String sql="select * from login where userid=?";  
		    return temp.queryForObject(Quries.LOGIN, new Object[]{login.getUserid()},new BeanPropertyRowMapper<Registration>(Registration.class));  
	}

}
