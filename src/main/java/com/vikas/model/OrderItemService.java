package com.vikas.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.OrderItem;
import com.vikas.entity.Ordertable;
import com.vikas.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository oir;
	@Autowired
	private OrdertableService ots;	
	public String save(OrderItem oi) {
		oir.save(oi);
		OrderItem oi1=oir.findById(oi.getOrderitemId()).get();
		
		//oi1.setAmount();
		Ordertable ordertable=ots.get(oi1.getOrdertable().getOrderId());
		ordertable.setTotalAmount(ordertable.getTotalAmount()+oi1.getQuantity()*(oi1.getProduct().getPrice()));
		oi1.setAmount(oi1.getQuantity()*(oi1.getProduct().getPrice()));
		//String a=ots.update(ordertable);
		//String ot=ots.update( ordertable);
		System.out.println(oi.getAmount());
		oir.save(oi1);
		return "added succesfully";
	}
	public Optional<OrderItem> get(int id) {
		Optional<OrderItem> o=oir.findById(id);
		return o;
	}
	public String delete(int id) {
		oir.deleteById(id);
		return "success";
	}
}
