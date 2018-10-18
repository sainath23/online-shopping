package com.doitgeek.shoppingbackend.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = -7205468141891676493L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String brand;
	@JsonIgnore
	private String description;
	@Column(name = "unit_price")
	private Double unitPrice;
	private Integer quantity;
	@JsonIgnore
	@Column(name = "is_active")
	private Character isActive;
	@Column(name = "category_id")
	@JsonIgnore
	private Long categoryId;
	@JsonIgnore
	@Column(name = "supplier_id")
	private Long supplierId;
	private Long purchases;
	private Long views;
	
	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Character getIsActive() {
		return isActive;
	}
	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Long getPurchases() {
		return purchases;
	}
	public void setPurchases(Long purchases) {
		this.purchases = purchases;
	}
	public Long getViews() {
		return views;
	}
	public void setViews(Long views) {
		this.views = views;
	}
	
}
