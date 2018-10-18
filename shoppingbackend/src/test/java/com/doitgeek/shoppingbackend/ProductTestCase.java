package com.doitgeek.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doitgeek.shoppingbackend.dao.ProductDao;
import com.doitgeek.shoppingbackend.entity.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDao productDao;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.doitgeek.shoppingbackend");
		context.refresh();
		
		productDao = (ProductDao) context.getBean("productDao");
	}
	
	@Test
	public void testGetActiveProducts() {
		assertEquals("Something went wrong", 5, productDao.findAll().size());
	}
}
