package com.vikas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Product;
import com.vikas.model.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
		private ProductService ps;
	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product) {
		return ps.saveProduct(product);
	}
	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable int id) {
		return ps.getProduct(id);
	}
	@GetMapping("/get")
	public List<Product> getAllProduct() {
		return ps.getAllProducts();
	}
	@PostMapping("/update")
	public String updateProduct(@RequestBody Product product) {
		return ps.updateProduct(product);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return ps.deleteProduct(id);
	}
	}
