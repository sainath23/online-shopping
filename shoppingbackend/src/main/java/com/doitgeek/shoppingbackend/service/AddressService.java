package com.doitgeek.shoppingbackend.service;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.Address;

public interface AddressService {
	Integer create(Address address);
	Address find(Integer id);
	List<Address> findAll();
	void update(Address address);
	void delete(Integer id);
	void delete(Address address);
}
