package com.doitgeek.onlineshopping.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.doitgeek.onlineshopping.model.RegisterModel;
import com.doitgeek.shoppingbackend.entity.Address;
import com.doitgeek.shoppingbackend.entity.Cart;
import com.doitgeek.shoppingbackend.entity.User;
import com.doitgeek.shoppingbackend.service.AddressService;
import com.doitgeek.shoppingbackend.service.UserService;

@Component
public class RegisterAction {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;

	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel model, User user) {
		model.setUser(user);
	}
	
	public void addAddress(RegisterModel model, Address address) {
		model.setAddress(address);
	}
	
	public String registerUser(RegisterModel model) {
		// Fetch the user
		User user = model.getUser();
		if(user.getRole().equalsIgnoreCase("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			cart.setCartLine(0);
			cart.setGrandTotal(0D);
			user.setCart(cart);
		}
		// Save user
		Long userId = userService.create(user);
		
		// Fetch address
		Address address = model.getAddress();
		address.setUserId(userId);
		address.setBilling('Y');
		address.setShipping('N');
		// Save address
		addressService.create(address);
		
		return "success";
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			error.addMessage(new MessageBuilder()
									.error()
									.source("confirmPassword")
									.defaultText("Password does not match!")
									.build());
			transitionValue = "failure";
		}
		
		if(userService.findUserByEmail(user.getEmail()) != null) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email already exists!")
					.build());
			transitionValue = "failure";
		}
		
		return transitionValue;
	}
}
