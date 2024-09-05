package com.vikas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Cart;
import com.vikas.model.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cs;
	
	@PostMapping("/save")
	public String save(@RequestBody Cart c) {
		return cs.save(c);
	}
	@GetMapping("/get/{id}")
	public Cart get(@PathVariable int id) {
		return cs.get(id);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return cs.delete(id);	}
}
