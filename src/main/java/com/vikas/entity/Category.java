package com.vikas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(
       
        uniqueConstraints=
            @UniqueConstraint(columnNames={"name"})
    )
public class Category {
	@Id
	private int categoryId;
	private String name;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
