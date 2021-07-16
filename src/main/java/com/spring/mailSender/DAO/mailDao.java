package com.spring.mailSender.DAO;

import org.springframework.web.multipart.MultipartFile;

public interface mailDao {
	public boolean sendMail(String email,String pass,String to,String subject,String message,String file);
}
