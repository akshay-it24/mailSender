package com.spring.mailSender.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.mailSender.DAO.userDao;
import com.spring.mailSender.VO.user;

public class userDetailService implements UserDetailsService {

	@Autowired
	private userDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user u=this.userDao.getUserByuserName(username);
		
		if(u==null) {
			throw new UsernameNotFoundException("Counld not found User");
		}
		
		userDetail userDetail=new userDetail(u);
		
		return userDetail;
	}

}
