package com.railway.bean;

public class Trains {

	private String trainno;
	private String trainname;
	private int seats;
	private String source;
	private String destination;
	private String arrival;
	private String departure;
	private int capacity;
	private String day;
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getTrainno() {
		return trainno;
	}
	public void setTrainno(String trainno) {
		this.trainno = trainno;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
