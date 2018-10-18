package com.doitgeek.shoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doitgeek.shoppingbackend.dao.ProductDao;
import com.doitgeek.shoppingbackend.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Long create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product find(Long id) {
		return productDao.find(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void delete(Long id) {
		productDao.delete(id);
	}

	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getActiveProducts() {
		return productDao.getActiveProducts();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getActiveProductsByCategoryId(Long categoryId) {
		return productDao.getActiveProductsByCategoryId(categoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getLatestActiveProducts(Integer count) {
		return productDao.getLatestActiveProducts(count);
	}

}
