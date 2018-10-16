package com.doitgeek.shoppingbackend.dao;

import java.util.List;

import com.doitgeek.shoppingbackend.entity.Category;

public interface CategoryDao {

	List<Category> findAll();
	Category findById(Long id);
}
