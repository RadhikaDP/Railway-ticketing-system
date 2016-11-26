package com.railway.dao;


import java.sql.SQLException;

import com.railway.bean.Registration;

public interface LoginDao {

	public Registration getLoginDetails(Registration login);

	public String getrole(String userid) throws SQLException;
}
