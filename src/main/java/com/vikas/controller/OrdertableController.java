package com.vikas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Ordertable;
import com.vikas.model.OrdertableService;

@RestController
@RequestMapping("/ordertable")
public class OrdertableController {

	@Autowired
	private OrdertableService ots;
	
	@PostMapping("/save")
	public String saveProduct(@RequestBody Ordertable product) {
		return ots.save(product);
	}
	@GetMapping("/get/{id}")
	public Ordertable getProduct(@PathVariable int id) {
		return ots.get(id);
	}
	@GetMapping("/get")
	public List<Ordertable> getAllProduct() {
		return ots.get();
	}
	@PostMapping("/update")
	public String updateProduct(@RequestBody Ordertable product) {
		return ots.update(product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return ots.delete(id);
	}
}
