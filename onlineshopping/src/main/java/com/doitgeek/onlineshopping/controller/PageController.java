package com.doitgeek.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doitgeek.onlineshopping.exception.ProductNotFoundException;
import com.doitgeek.shoppingbackend.entity.Category;
import com.doitgeek.shoppingbackend.entity.Product;
import com.doitgeek.shoppingbackend.service.CategoryService;
import com.doitgeek.shoppingbackend.service.ProductService;

@Controller
public class PageController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		LOGGER.info("Inside PageController index method INFO");
		LOGGER.debug("Inside PageController index method DEBUG");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryService.findAll());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryService.findAll());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("page");
		Category category = categoryService.find(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryService.findAll());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable Long id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		Product product = productService.find(id);
		if(product == null) {
			throw new ProductNotFoundException();
		}
		product.setViews(product.getViews() + 1);
		productService.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
}
