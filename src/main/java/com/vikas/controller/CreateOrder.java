package com.vikas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Cart;
import com.vikas.entity.CartItem;
import com.vikas.entity.OrderItem;
import com.vikas.entity.Ordertable;
import com.vikas.model.CartItemService;
import com.vikas.model.CartService;
import com.vikas.model.OrderItemService;
import com.vikas.model.OrdertableService;
import com.vikas.model.UserService;

@RestController("/createorder")

public class CreateOrder {
	@Autowired
	private OrdertableService ots;
	@Autowired
	private CartService cs;
	@Autowired
	private UserService userservice;
	@Autowired
	private CartItemService cartitemservice;
	@Autowired
	private OrderItemService orderitemservice;
	public   int createor(int id) {
		Cart c=cs.get(id);
		int userid=c.getUser().getUserId();
		return userid;
	}
	@PostMapping("/create/{id}")
	public String create(@PathVariable int id, @RequestBody Ordertable ordertable) {
		Ordertable ot=new Ordertable();
		String date=java.time.LocalDate.now().toString();
		
		ot.setDate(date);
		ot.setTotalAmount(0);
		ot.setUser(userservice.getUser(createor(id)));
		ots.save(ot);
		List<CartItem> allitems=cartitemservice.findAllByCartId(id);
		for(CartItem c:allitems) {
			OrderItem ois=new OrderItem();
			ois.setOrdertable(ot);
			ois.setAmount(c.getQuantity()*(c.getProduct().getPrice()));
			ois.setProduct(c.getProduct());
			ois.setQuantity(c.getQuantity());
			orderitemservice.save(ois);
			cartitemservice.delete(c.getCartItemId());
		}
		return "success";
		
		
		
		
		
	}

}
