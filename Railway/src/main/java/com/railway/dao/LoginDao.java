package com.railway.dao;

import com.railway.bean.Login;
import com.railway.bean.Registration;

public interface LoginDao {

	public Registration getLoginDetails(Registration login);
}
