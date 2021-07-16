package com.spring.mailSender.Controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mailSender.DAO.*;
@Controller
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private mailDao mailDao;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(HttpServletRequest request,Principal principal,@RequestParam("file") MultipartFile file,HttpSession session) {
		String email=principal.getName();
		String pass=request.getParameter("password");
		String to=request.getParameter("to");
		String subject=request.getParameter("subject");
		String msg=request.getParameter("msg");
		String sendFile="";
		String UPLOAD_DIR="";
		String filename="";
		boolean flag=false;
		if(file.isEmpty()) {
			sendFile="null";
			flag=this.mailDao.sendMail(email, pass, to, subject, msg,sendFile);
		}
		else {
			try {
				
				UPLOAD_DIR = new ClassPathResource("static").getFile().getAbsolutePath();
				filename=file.getOriginalFilename();
				
				Path path=Paths.get(UPLOAD_DIR+File.separator+filename);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				sendFile=UPLOAD_DIR+File.separator+filename;
				flag=this.mailDao.sendMail(email, pass, to, subject, msg,sendFile);
				
				if(flag) {
					Files.delete(path);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		if(flag) {
			session.setAttribute("flag", "success");
		}
		return "redirect:/user/index";
	}
}
