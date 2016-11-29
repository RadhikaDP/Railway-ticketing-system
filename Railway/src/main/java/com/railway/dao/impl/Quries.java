package com.railway.dao.impl;

public interface Quries {
	
	public String LOGIN = "select * from users where userid=?";
	
	public String ADD_USER = "insert into users(userid,password,firstname,lastname,email,phone) values (?,?,?,?,?,?)";
	
	public String GET_SOURCE ="select source from trains";
	
	public String GET_DESTINATION ="select destination from trains";
	
	public String TRAINS_BW_STATIONS="select * from trains where source=? and destination=?";
	
	public String ADD_Passengers="insert into passenger(trainno,name,age,gender,berth,userid) values (?,?,?,?,?,?)";
	
	public String GET_BOOKINGS="select * from passenger where userid=?";
	
	public String CANCEL="delete from passenger where userid=? and name=?";
	
	public String CANCEL_ALL="delete from passenger where userid=?";
	
	public String DECREASE_SEATS="update trains set seats = seats - ? where trainno =?";
	
	public String ADD_DELAY="insert into delay (trainno,time)values(?,?)";
	
	public String GET_PASSENGER_BYTRAIN ="select * from passenger where trainno=?";
	
	public String GET_GMAIL="select email from users where userid=? ";
	
	public String ADD_HISTORY="insert into cancelation () ";
	
	public String GET_SENIOURS=" (select name,age,gender from passenger where ((gender='male' and age>'65')or(gender='female' and age>'60'))and( trainno=?))";
	
	public String GET_TRAINS1=" select * from trains where source=? and destination=? and ?='Y'";
	
	public String GET_REG_PASS=" select name,age,gender from passenger where trainno=? group by name,age,gender having count(name)>10";
	//change to date late
	public String GET_ALL_PASS=" select name,age,gender from passenger where trainno=? ";

} 
