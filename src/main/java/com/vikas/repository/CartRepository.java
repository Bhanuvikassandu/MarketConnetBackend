package com.vikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
