package com.railway.dao.impl;

public interface Quries {
	
	public String LOGIN = "select * from users where userid=?";
	public String ADD_USER = "insert into users(userid,password,firstname,lastname,email,phone) values (?,?,?,?,?,?)";
	public String GET_SOURCE ="select source from trains";
	public String GET_DESTINATION ="select destination from trains";
	public String TRAINS_BW_STATIONS="select * from trains where source= ? and destination= ?";
} 
