package com.spring.mailSender.DAO;

import com.spring.mailSender.VO.user;

public interface userDao {
	public void saveUser(user u);
	public user getUserByuserName(String username);
}
