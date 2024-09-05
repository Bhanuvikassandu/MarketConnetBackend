package com.vikas.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Ordertable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int orderId;
private String date;
private double totalAmount;
@ManyToOne
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getOrderId() {
	return orderId;
}

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}


}
