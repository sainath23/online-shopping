package com.doitgeek.onlineshopping.model;

import java.io.Serializable;

import com.doitgeek.shoppingbackend.entity.Address;
import com.doitgeek.shoppingbackend.entity.User;

public class RegisterModel implements Serializable {

	private static final long serialVersionUID = -8713330837182935691L;

	private User user;
	
	private Address address;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
