package com.vikas.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.Ordertable;
import com.vikas.repository.OrdertableRepository;

@Service
public class OrdertableService {

	@Autowired
	private OrdertableRepository or;
	
	public String save(Ordertable ot) {
		or.save(ot);
		return "success";
	}
	public  Ordertable get(int id) {
		return or.findById(id).get();
	}
	public String update(Ordertable ot) {
		Ordertable exist= or.findById(ot.getOrderId()).orElse(null);
		if(exist!=null) {
			exist.setDate(ot.getDate());
			exist.setTotalAmount(ot.getTotalAmount());
			exist.setUser(ot.getUser());
			or.save(exist);
			return "success";
		}
		else
			return "fail";
	}
	public String delete(int id) {
		or.deleteById(id);
		return "success";

	}
	public List<Ordertable> get(){
		return or.findAll();
		}
}
