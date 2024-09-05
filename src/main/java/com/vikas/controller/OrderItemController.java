package com.vikas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.OrderItem;
import com.vikas.model.OrderItemService;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

	@Autowired
	private OrderItemService ois;
	
	@PostMapping("/save")
	public String save(@RequestBody OrderItem oi) {
		//OrdertableService ots=new OrdertableService();
		
		return ois.save(oi);
	}
	@GetMapping("/get/{id}")
	public Optional<OrderItem> get(@PathVariable int id ) {
		return ois.get(id);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return ois.delete(id);
	}
}
