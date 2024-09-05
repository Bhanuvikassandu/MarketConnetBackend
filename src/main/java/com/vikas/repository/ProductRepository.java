package com.vikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
