package com.vikas.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.Category;
import com.vikas.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cr;
	public String saveCategory( Category u) {
		cr.save(u);
		return "Category registered Successfully";
	}
	public Optional<Category> getCategory(int id) {
			Optional<Category> Category =cr.findById(id);
				return Category;
	}
	public String updateCategory(Category u) {
		Category Category=cr.findById(u.getCategoryId()).orElse(null);
		if(Category!=null) {
			//Category.setCategoryMail(u.getCategoryName());
			Category.setName(u.getName());
			//Category.setCategoryPassword(u.getCategoryPassword());
			cr.save(Category);
			return "Success";
		}
		else 
			return "Fali";
	}
	public String deleteCategory(int id) {
		Category Category=cr.findById(id).orElse(null);
		if(Category!=null) {
			cr.deleteById(id);
			return "deleted";
		}
		else 
			return "fail";
	}
	public List<Category> getAllProducts(){
		return cr.findAll();
	}
	
}
