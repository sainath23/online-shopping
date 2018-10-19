package com.doitgeek.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doitgeek.shoppingbackend.entity.Product;
import com.doitgeek.shoppingbackend.service.ProductService;

@RestController
@RequestMapping("/rest")
public class JsonDataController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all/products")
	public List<Product> getAllProducts() {
		return productService.getActiveProducts();
	}
	
	@GetMapping("/category/{id}/products")
	public List<Product> getCategoryProductsByCategoryId(@PathVariable Long id) {
		return productService.getActiveProductsByCategoryId(id);
	}
	
	@GetMapping("/admin/all/products")
	public List<Product> getAllProductsForAdmin() {
		return productService.findAll();
	}
}
