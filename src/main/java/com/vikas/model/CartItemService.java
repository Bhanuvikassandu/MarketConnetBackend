package com.vikas.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.CartItem;
import com.vikas.repository.CartItemRepository;

@Service
public class CartItemService {

	@Autowired
	private CartItemRepository cir;
	
	public String save( CartItem ci) {
		cir.save(ci);
		return "Item added successfully";
	}
	public CartItem get(int id) {
		return cir.findById(id).get();	
		}
	public String delete(int id) {
		cir.deleteById(id);
		return "item deleted";
	}
	public List<CartItem> findAllByCartId(int id){
		List<CartItem> list= cir.findAll();
		List<CartItem> res=new ArrayList<>();
		for(CartItem c: list) {
			if(c.getCart().getCartId()==id)
				res.add(c);
		}
		return res;
	}
}
