package com.doitgeek.shoppingbackend.dao;

import com.doitgeek.shoppingbackend.entity.User;

public interface UserDao extends GenericDao<User, Long> {

	User findUserByEmail(String email);
}
