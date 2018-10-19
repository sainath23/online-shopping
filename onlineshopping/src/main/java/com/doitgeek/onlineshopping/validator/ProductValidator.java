package com.doitgeek.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.doitgeek.shoppingbackend.entity.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		// Whether file has been selected
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/jpeg") 
				|| product.getFile().getContentType().equals("image/png"))) {
			errors.rejectValue("file", null, "Only allowed image file to upload are .jpg, .jpeg, .png");
			return;
		}
	}

}
