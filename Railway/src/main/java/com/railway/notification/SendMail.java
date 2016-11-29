package com.railway.notification;


import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.*;

  
public class SendMail {  
 public static void sendmail(String mail,int time,String trainNo){  

 String to=mail;//change accordingly  
  
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
 props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("radhika.dp16@gmail.com","rechal20");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress("radhika.dp16@gmail.com"));//change accordingly  
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject("Train delay");  
   message.setText("Your train with train number"+trainNo+" has been delayed today by " +time +"minutes");  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   
 }  
}  