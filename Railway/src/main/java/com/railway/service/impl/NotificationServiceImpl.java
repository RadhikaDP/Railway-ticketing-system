package com.railway.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.railway.bean.Delay;
import com.railway.bean.Passenger;
import com.railway.dao.NotificationDao;
import com.railway.notification.SendMail;
import com.railway.service.NotificationService;


public class NotificationServiceImpl implements NotificationService{
	@Autowired
	NotificationDao notdao;

	@Override
	public void addDelay(Delay delay) {
		notdao.addDelay(delay);
		List<Passenger> pass=notdao.getpassengers(delay.getTrainno());
		sendMail(pass,delay.getTime(),delay.getTrainno());
	}

	private void sendMail(List<Passenger> pass, int time ,String trainNo) {
		
		Iterator<Passenger> it = pass.iterator();

	while(it.hasNext())
	{
		String userid=it.next().getUser();
		System.out.println(userid);
		String gmail = notdao.getmail(userid);
		SendMail.sendmail(gmail, time, trainNo);
	}
		
		
	}
	
	
}

