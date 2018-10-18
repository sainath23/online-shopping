package com.doitgeek.shoppingbackend.dao;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.Product;

public interface ProductDao extends GenericDao<Product, Long> {

	List<Product> getActiveProducts();
	List<Product> getActiveProductsByCategoryId(Long categoryId);
	List<Product> getLatestActiveProducts(Integer count);
}
