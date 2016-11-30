package com.railway.dao.impl;

public interface Quries {
	
	public String LOGIN = "select * from users where userid=?";
	
	public String ADD_USER = "insert into users(userid,password,firstname,lastname,email,phone) values (?,?,?,?,?,?)";
	
	public String GET_SOURCE ="select distinct source from train";
	
	public String GET_DESTINATION ="select distinct destination from train";
	
	public String ADD_Passengers="insert into passenger(trainno,name,age,gender,berth,userid,traveldate) values (?,?,?,?,?,?,?)";
	
	public String GET_BOOKINGS="select * from passenger where userid=?";
	
	public String CANCEL="delete from passenger where userid=? and name=?";
	
	public String CANCEL_ALL="delete from passenger where userid=?";
	
	public String DECREASE_SEATS="update train set seats = seats - ? where trainno =?";
	
	public String ADD_DELAY="insert into delay (trainno,time)values(?,?)";
	
	public String GET_PASSENGER_BYTRAIN ="select * from passenger where trainno=?";
	
	public String GET_GMAIL="select email from users where userid=? ";
	
	public String ADD_HISTORY="insert into cancelation () ";
	
	public String GET_SENIOURS=" (select name,age,gender from passenger where ((gender='male' and age>'65')or(gender='female' and age>'60'))and( trainno=?))";
	
	public String GET_REG_PASS=" select name,age,gender from passenger where trainno=? group by name,age,gender having count(name)>10";

	public String GET_ALL_PASS=" select name,age,gender from passenger where trainno=? ";
	
	public String GET_CANCELATION="select * from cancelation where userid=?";
	
	public String DELETE_OLD ="delete from passenger WHERE traveldate < ?";
	
	public String GET_RES_HIST ="select * from reservationhist where userid=?";
	

} 
