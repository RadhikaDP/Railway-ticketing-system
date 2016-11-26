package com.railway.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.railway.bean.Registration;
import com.railway.dao.RegistrationDao;

public class RegistrationDaoImpl implements RegistrationDao{

	@Autowired
	JdbcTemplate temp;  
	  

	public void setTemplate(JdbcTemplate temp) {  
	    this.temp = temp;  
	}
	
	@Override
	public int adduser(Registration reg ) {

	    return temp.update(Quries.ADD_USER,reg.getUserid(),reg.getPassword(),reg.getFirstname(),reg.getLastname(),reg.getEmail(),reg.getPhone());
	}

}
