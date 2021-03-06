package com.doitgeek.shoppingbackend.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User implements Serializable {

	private static final long serialVersionUID = -5962261112781166786L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	@NotBlank(message = "Please enter first name!")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Please enter last name!")
	private String lastName;
	
	private String role;
	
	@Column(name = "is_enabled")
	private Character isEnabled = 'Y';
	
	@NotBlank(message = "Please enter password!")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@NotBlank(message = "Please enter email!")
	private String email;
	
	@Column(name = "contact_number")
	@NotBlank(message = "Please enter contact number!")
	private String contactNumber;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Character getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Character isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", isEnabled=" + isEnabled + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", email=" + email + ", contactNumber=" + contactNumber + ", cart=" + cart + "]";
	}
	
}
