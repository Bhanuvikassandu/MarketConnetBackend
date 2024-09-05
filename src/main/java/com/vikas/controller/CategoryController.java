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

import com.vikas.entity.Category;
import com.vikas.model.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService cs;
	
	@PostMapping("/save")
	public String saveCategory(@RequestBody Category ct) {
		return cs.saveCategory(ct);
	}
	@GetMapping("/get/{id}")
	public Optional<Category> getCategory(@PathVariable int id) {
		return cs.getCategory(id);
	}
	@PostMapping("/update")
	public String updateCategory(@RequestBody Category ct) {
		return cs.updateCategory(ct);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return cs.deleteCategory(id);
	}
	@GetMapping("/get")
	public List<Category> getAllProduct() {
		return cs.getAllProducts();
	}
	
	
	
}
