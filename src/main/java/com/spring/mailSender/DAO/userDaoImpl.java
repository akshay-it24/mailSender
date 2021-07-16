package com.spring.mailSender.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mailSender.VO.user;

@Repository
@Transactional
public class userDaoImpl implements userDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(user u) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
	}

	@Override
	public user getUserByuserName(String username) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<user> q=session.createQuery("from user where email='"+username+"'");
		List<user> ls=q.list();
		return ls.get(0);
	}

}
