package com.vikas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.CartItem;
import com.vikas.model.CartItemService;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {

	@Autowired
	private CartItemService cis;
	
	@PostMapping("/save")
	public String save(@RequestBody CartItem ci) {
		return cis.save(ci);
	}
	@GetMapping("/get/{id}")
	public CartItem get(@PathVariable int id) {
		return cis.get(id);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return cis.delete(id);
	}
}
