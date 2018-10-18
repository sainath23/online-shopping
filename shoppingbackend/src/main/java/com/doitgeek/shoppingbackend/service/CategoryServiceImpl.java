package com.doitgeek.shoppingbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doitgeek.shoppingbackend.dao.CategoryDao;
import com.doitgeek.shoppingbackend.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Long create(Category category) {
		return categoryDao.create(category);
	}

	@Override
	public Category find(Long id) {
		return categoryDao.find(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(Long id) {
		categoryDao.delete(id);
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

}
