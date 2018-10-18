package com.doitgeek.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doitgeek.shoppingbackend.dao.CategoryDao;
import com.doitgeek.shoppingbackend.entity.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.doitgeek.shoppingbackend");
		context.refresh();
		
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Television");
		category.setDescription("This is description for tv");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table", 1, );
	}*/
	
	@Test
	public void testFindCategory() {
		category = categoryDao.find(1L);
		assertEquals("Successfully fetch category", "Television", category.getName());
	}
}
