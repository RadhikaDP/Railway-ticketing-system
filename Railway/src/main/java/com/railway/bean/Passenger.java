package com.railway.bean;

import java.util.Date;

public class Passenger {
private String user;
private String trainno;
private String Name;
private String Age;
private String gender;
private String berth;
private String Bookingid;
private Date travelDate;

public String getBookingid() {
	return Bookingid;
}
public void setBookingid(String bookingid) {
	Bookingid = bookingid;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getTrainno() {
	return trainno;
}
public void setTrainno(String trainno) {
	this.trainno = trainno;
}

public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}

public String getAge() {
	return Age;
}
public void setAge(String age) {
	Age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBerth() {
	return berth;
}
public void setBerth(String berth) {
	this.berth = berth;
}
public Date getTravelDate() {
	return travelDate;
}
public void setTravelDate(Date travelDate) {
	this.travelDate = travelDate;
}



}
