package com.doitgeek.shoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doitgeek.shoppingbackend.dao.AddressDao;
import com.doitgeek.shoppingbackend.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public Integer create(Address address) {
		return addressDao.create(address);
	}

	@Override
	public Address find(Integer id) {
		return addressDao.find(id);
	}

	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public void update(Address address) {
		addressDao.update(address);
	}

	@Override
	public void delete(Integer id) {
		addressDao.delete(id);
	}

	@Override
	public void delete(Address address) {
		addressDao.delete(address);
	}

}
