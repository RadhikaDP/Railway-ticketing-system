package com.railway.service;

import java.sql.SQLException;

import com.railway.bean.Login;
import com.railway.bean.Registration;

public interface LoginService {

	public abstract boolean ValidateUser(Registration login) throws SQLException;
	
}