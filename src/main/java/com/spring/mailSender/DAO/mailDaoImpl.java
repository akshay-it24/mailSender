package com.spring.mailSender.DAO;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Repository;


@Repository
public class mailDaoImpl implements mailDao {

	@Override
	public boolean sendMail(String email, String pass, String to, String subject, String message,String file) {
		// TODO Auto-generated method stub
		Properties properties=System.getProperties();
		boolean flag=false;
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(email,pass);
			}
			
		});
		
		session.setDebug(true);
		MimeMessage m=new MimeMessage(session);
		 try {
			 m.setFrom(email);
			 m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			 m.setSubject(subject);
			 
			 if(file=="null") {
				 m.setText(message);
			 }
			 
			 if(file!="null") {
				 Multipart mp=new MimeMultipart();
				 MimeBodyPart mbp=new MimeBodyPart();
				 mbp.setText(message);
				 mp.addBodyPart(mbp);
				 
				 mbp=new MimeBodyPart();
				 mbp.attachFile(file);
				 mp.addBodyPart(mbp);
				 m.setContent(mp);
			 }
			
			 Transport.send(m);
			 flag=true;
			 System.out.println("successfully sent");
			 
		} catch (Exception e) {
			// TODO: handle exception
		} 
		 return flag;
	}
	

}
