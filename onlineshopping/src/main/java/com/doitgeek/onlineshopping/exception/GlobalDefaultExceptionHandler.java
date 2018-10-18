package com.doitgeek.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDescription", "The page you are looking for is not available now!");
		mv.addObject("title", "404 Page not found");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available!");
		mv.addObject("errorDescription", "The product you are looking for is not available right now!");
		mv.addObject("title", "Product Unavilable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Bad Request!");
		mv.addObject("errorDescription", "Something went wrong! Bad request.");
		mv.addObject("title", "Error");
		return mv;
	}
}
