package com.doitgeek.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.doitgeek.onlineshopping.util.FileUploadUtil;
import com.doitgeek.onlineshopping.validator.ProductValidator;
import com.doitgeek.shoppingbackend.entity.Category;
import com.doitgeek.shoppingbackend.entity.Product;
import com.doitgeek.shoppingbackend.service.CategoryService;
import com.doitgeek.shoppingbackend.service.ProductService;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	private final static Logger LOGGER = LoggerFactory.getLogger(ManagementController.class);

	@GetMapping("/products")
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product product = new Product();
		product.setSupplierId(1L);
		product.setIsActive('Y');
		product.setPurchases(0L);
		product.setViews(0L);
		mv.addObject("product", product);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product submitted successfully!");
			}
		}
		return mv;
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}

	@PostMapping("/products")
	public String processProductForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		// Check for errors
		if(product.getId() == null) {
			LOGGER.info("New product validation...");
			new ProductValidator().validate(product, bindingResult);
		}
		else {
			LOGGER.info("Existing product validation...");
			if(!product.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(product, bindingResult);
			}
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for product submission!");
			return "page";
		}
		LOGGER.info("Product: " + product.toString());
		if(product.getId() == 0) {
			productService.create(product);
		}
		else {
			productService.update(product);
		}
		if(!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtil.uploadFile(request, product.getFile(), product.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
	@PostMapping("/product/{id}/activation")
	@ResponseBody
	public String processProductActivation(@PathVariable Long id) {
		Product product = productService.find(id);
		if("Y".equalsIgnoreCase(Character.toString(product.getIsActive()))) {
			product.setIsActive('N');
		}
		else {
			product.setIsActive('Y');
		}
		productService.update(product);
		boolean isActive = "Y".equalsIgnoreCase(Character.toString(product.getIsActive())) ? true : false;
		return (isActive) ? "You have successfully activated product with id " + product.getId() : 
							"You have successfully deactivated product with id " + product.getId();
	}
	
	@GetMapping("/{id}/product")
	public ModelAndView showEditProduct(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product product = productService.find(id);
		mv.addObject("product", product);
		return mv;
	}
}
