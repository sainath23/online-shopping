package com.doitgeek.shoppingbackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doitgeek.shoppingbackend.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	private Session getCurrentSession() {
		return sessionfactory.getCurrentSession();
	}

	@Override
	public User findUserByEmail(String email) {
		User user= null;
		try {
			user = getCurrentSession()
					.createQuery("FROM User WHERE email = :email", User.class)
					.setParameter("email", email)
					.getSingleResult();
			return user;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
