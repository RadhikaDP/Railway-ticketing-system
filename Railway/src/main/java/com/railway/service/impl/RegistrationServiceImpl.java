package com.railway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Registration;
import com.railway.dao.RegistrationDao;
import com.railway.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegistrationDao regDao;
	
	@Override
	public int adduser(Registration reg) {
		
		return regDao.adduser(reg);
	}

}
