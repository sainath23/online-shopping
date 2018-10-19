package com.doitgeek.shoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doitgeek.shoppingbackend.dao.UserDao;
import com.doitgeek.shoppingbackend.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Long create(User user) {
		return userDao.create(user);
	}

	@Override
	public User find(Long id) {
		return userDao.find(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	@Transactional
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

}
