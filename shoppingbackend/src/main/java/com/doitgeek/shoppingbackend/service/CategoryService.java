package com.doitgeek.shoppingbackend.service;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.Category;

public interface CategoryService {
	Long create(Category category);
	Category find(Long id);
	List<Category> findAll();
	void update(Category category);
	void delete(Long id);
	void delete(Category category);
}
