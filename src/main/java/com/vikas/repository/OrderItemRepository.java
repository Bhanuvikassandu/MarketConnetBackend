package com.vikas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
