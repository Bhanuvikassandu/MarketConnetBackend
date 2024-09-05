package com.vikas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.entity.Cart;
import com.vikas.entity.Product;
import com.vikas.entity.User;
import com.vikas.model.CartService;
import com.vikas.model.ProductService;
import com.vikas.model.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/home")
public class HomeController  {

	@Autowired
	private UserService userservice;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productservice;
	@GetMapping("/")
	public String homepage(HttpServletRequest request,HttpServletResponse response) 
	{
		HttpSession session=request.getSession();
		if(session.getAttribute("name")!=null)
			
		return "HI  "+session.getAttribute("name")+"!!!!!"+session.getAttribute("role");
		return "login kaa";
			
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,@RequestBody User user) 
	{
		HttpSession session=request.getSession();
		if(session.getAttribute("name")!=null)		
			return "already login ayinav";
		User exist=userservice.getUser(user.getUserId());
		if( exist.getUserPassword().equals(user.getUserPassword()))
		{
		session.setAttribute("role", exist.getRole());
		session.setAttribute("name", exist.getUserName());
		session.setAttribute("id", exist.getUserId());
		
		session.setMaxInactiveInterval(60);
		return "login ayinav le";
		}
		return "incorrect";
		
		
	}
	@GetMapping("/status")
	public String status(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		if(session.getAttribute("name")!=null)
		return (String) session.getAttribute("name");
		return "m lev ";
	}
	@PostMapping("/signUp")
	public String signUp(HttpServletRequest request,@RequestBody User user) {
		HttpSession session=request.getSession();
		if(session.getAttribute("name")==null) {
			String s=userservice.saveUser(user);
			Cart c= new Cart();
			c.setUser(user);
			cartService.save(c);
			return s;}
		return "first logout ayyi signup ka ra reyy!!!";
	}
	@GetMapping("product/get")
	public List<Product> getAllProduct(HttpServletResponse response,HttpServletRequest request)  {
		HttpSession session=request.getSession();
		
			return productservice.getAllProducts();
//			return null;
		
		
		
	}
	
	
}
