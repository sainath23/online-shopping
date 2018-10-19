package com.doitgeek.shoppingbackend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -3872787258393835893L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter address line one!")
	private String addressLineOne;
	
	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter address line two!")
	private String addressLineTwo;
	
	@NotBlank(message = "Please enter city name!")
	private String city;
	
	@NotBlank(message = "Please enter state name!")
	private String state;
	
	@NotBlank(message = "Please enter country!")
	private String country;
	
	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code!")
	private String postalCode;
	
	private Character shipping;
	private Character billing;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Character getShipping() {
		return shipping;
	}
	public void setShipping(Character shipping) {
		this.shipping = shipping;
	}
	public Character getBilling() {
		return billing;
	}
	public void setBilling(Character billing) {
		this.billing = billing;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}
	
	
}
