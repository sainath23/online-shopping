package com.doitgeek.shoppingbackend.dao;

import org.springframework.stereotype.Repository;

import com.doitgeek.shoppingbackend.entity.Cart;

@Repository
public class CartDaoImpl extends GenericDaoImpl<Cart, Integer> implements CartDao {

}
