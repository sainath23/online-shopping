package com.doitgeek.shoppingbackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = -8881703186905503116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cart_line")
	private Integer cartLine;
	
	@Column(name = "grand_total")
	private Double grandTotal;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCartLine() {
		return cartLine;
	}

	public void setCartLine(Integer cartLine) {
		this.cartLine = cartLine;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartLine=" + cartLine + ", grandTotal=" + grandTotal + ", user=" + user + "]";
	}
}
