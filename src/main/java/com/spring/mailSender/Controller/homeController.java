package com.spring.mailSender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.mailSender.VO.user;
import com.spring.mailSender.DAO.userDao;


@Controller
public class homeController {
	
	@Autowired
	private userDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@GetMapping(value = "/login")
	public String home(Model model) {
		return "login";
	}
	
	@GetMapping(value="/signUp")
	public String sighUp(Model model) {
		model.addAttribute("user", new user());
		return "signUp";
	}
	
	@PostMapping(value = "/doSignUp")
	public String doSignUp(@ModelAttribute user user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user.setActive(true);
		user.setRole("ROLE_USER");
		this.userDao.saveUser(user);
		return "redirect:/login";
	}
}
