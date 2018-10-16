package com.doitgeek.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doitgeek.shoppingbackend.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1L);
		category.setName("Television");
		category.setDescription("This is descr for tv");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category = new Category();
		category.setId(2L);
		category.setName("Mobile");
		category.setDescription("This is descr for mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category = new Category();
		category.setId(3L);
		category.setName("Laptop");
		category.setDescription("This is descr for laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}
	
	@Override
	public List<Category> findAll() {
		return categories;
	}

	@Override
	public Category findById(Long id) {
		for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
