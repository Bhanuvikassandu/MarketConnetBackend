package com.vikas.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.Cart;
import com.vikas.entity.CartItem;
import com.vikas.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cr;
	
	public String save(Cart c) {
		cr.save(c);
		return "Cart added successfully";
	}
	public Cart get(int id) {
		Cart c=cr.findById(id).get();
		return c;
		
	}
	public String delete (int id) {
		cr.deleteById(id);
		return "deleted";
	}
	public Cart findAllByuserId(int id){
		List<Cart> list= cr.findAll();
		//List<CartItem> res=new ArrayList<>();
		for(Cart c: list) {
			if(c.getUser().getUserId()==id)
				return c;
		}
		return new Cart();
	}
	
}
