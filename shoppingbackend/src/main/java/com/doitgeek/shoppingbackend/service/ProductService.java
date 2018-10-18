package com.doitgeek.shoppingbackend.service;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.Product;

public interface ProductService {
	Long create(Product product);
	Product find(Long id);
	List<Product> findAll();
	void update(Product product);
	void delete(Long id);
	void delete(Product product);
	List<Product> getActiveProducts();
	List<Product> getActiveProductsByCategoryId(Long categoryId);
	List<Product> getLatestActiveProducts(Integer count);
}
