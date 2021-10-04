package com.techshop.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
@Entity
@Table (name = "account_client")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameProduct;
	@NonNull
	private int quantityOrdered;
	@NonNull
	private float price;
	private float total;
	private int idClient;
	
	//Constructors
	public Account() {
		
	}

	
	public Account(String nameProduct, int quantityOrdered, float price, int idClient) {
		super();
		this.nameProduct = nameProduct;
		this.quantityOrdered = quantityOrdered;
		this.price = price;
		this.total = quantityOrdered*price;
		this.idClient = idClient;
	}


	//Getters and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}
