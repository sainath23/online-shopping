package com.doitgeek.shoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doitgeek.shoppingbackend.dao.CartDao;
import com.doitgeek.shoppingbackend.entity.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;

	@Override
	public Integer create(Cart cart) {
		return cartDao.create(cart);
	}

	@Override
	public Cart find(Integer id) {
		return cartDao.find(id);
	}

	@Override
	public List<Cart> findAll() {
		return cartDao.findAll();
	}

	@Override
	public void update(Cart cart) {
		cartDao.update(cart);
	}

	@Override
	public void delete(Integer id) {
		cartDao.delete(id);
	}

	@Override
	public void delete(Cart cart) {
		cartDao.delete(cart);
	}

}
