package com.vikas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderitemId;
	@ManyToOne
	private Ordertable ordertable;
	@ManyToOne
	private Product product;
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private double amount;
	public int getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
	}
	public Ordertable getOrdertable() {
		return ordertable;
	}
	public void setOrdertable(Ordertable ordertable) {
		this.ordertable = ordertable;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		//this.amount = quantity*product.getPrice();
		this.amount=amount;
	}
	
}

