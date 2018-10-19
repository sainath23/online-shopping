package com.doitgeek.shoppingbackend.service;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.User;

public interface UserService {
	Long create(User user);
	User find(Long id);
	List<User> findAll();
	void update(User user);
	void delete(Long id);
	void delete(User user);
	User findUserByEmail(String email);
}
