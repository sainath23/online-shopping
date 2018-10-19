package com.doitgeek.shoppingbackend.service;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.Cart;

public interface CartService {
	Integer create(Cart cart);
	Cart find(Integer id);
	List<Cart> findAll();
	void update(Cart cart);
	void delete(Integer id);
	void delete(Cart cart);
}
