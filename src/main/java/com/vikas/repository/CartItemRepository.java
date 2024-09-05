package com.vikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}
