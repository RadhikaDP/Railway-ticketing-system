package com.railway.service.impl;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import com.railway.bean.Registration;
import com.railway.dao.LoginDao;
import com.railway.service.LoginService;


public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao logindao;
	@Override
	public boolean ValidateUser(Registration login) throws SQLException {

		Registration log = logindao.getLoginDetails(login);
		
		if(log.getPassword().equals(login.getPassword())){
			return true;
		}

		return false;
	}
	@Override
	public String getrole(String userid) throws SQLException {
		
		return logindao.getrole(userid);
	}

}
