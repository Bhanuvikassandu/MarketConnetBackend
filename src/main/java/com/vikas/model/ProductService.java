package com.vikas.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.Product;
import com.vikas.repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;
	
	public String saveProduct( Product p) {
		pr.save(p);
		return "Product Added Successfully";
	}
	public Product getProduct(int id) {
			Product product=pr.findById(id).get();
				return product;
	}
	public String updateProduct(Product p) {
		Product product=pr.findById(p.getProductId()).orElse(null);
		if(product!=null) {
			product.setProductName(p.getProductName());
			product.setCategory(p.getCategory());
			
			pr.save(product);
			return "Success";
		}
		else 
			return "Fali";
	}
	public String deleteProduct(int id) {
		Product product=pr.findById(id).orElse(null);
		if(product!=null) {
			pr.deleteById(id);
			return "deleted";
		}
		else 
			return "fail";
	}
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	
}
