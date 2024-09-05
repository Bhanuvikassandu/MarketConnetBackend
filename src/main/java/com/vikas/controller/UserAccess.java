
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

import com.vikas.entity.Cart;
import com.vikas.entity.CartItem;
import com.vikas.entity.OrderItem;
import com.vikas.entity.Ordertable;
import com.vikas.entity.Product;
import com.vikas.entity.User;
import com.vikas.model.CartItemService;
import com.vikas.model.CartService;
import com.vikas.model.OrderItemService;
import com.vikas.model.OrdertableService;
import com.vikas.model.ProductService;
import com.vikas.model.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserAccess {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private OrdertableService ordertableservice;
	
	@Autowired
	private OrderItemService orderitemservice;
	@Autowired
	private CartService cartservice;
	@Autowired
	private CartItemService cartitemservice;
	//HttpServletResponse response,@CookieValue(value = "role", defaultValue = "nouserexist") String username)
	
	@PostMapping("/update")
	public String updateUser(@RequestBody User user,HttpServletResponse response,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return userservice.updateUser(user);
			return "invalid access";
		

	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id,HttpServletResponse response,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return userservice.deleteUser(id);
			return "invalid access";
		
		//return "login required";
	}
	@GetMapping("/product/get/{id}")
	public String getProduct(@PathVariable int id,HttpServletResponse response,HttpServletRequest request){
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return productservice.getProduct(id).toString();
			return "invalid access";		
		
		//return "login required";
	}
	@GetMapping("product/get")
	public List<Product> getAllProduct(HttpServletResponse response,HttpServletRequest request)  {
		HttpSession session=request.getSession();
		if(session.getAttribute("role").equals("user"))
			return productservice.getAllProducts();
			return null;
		
		
		
	}
	@GetMapping("/logout")
	public String logout(HttpServletResponse response,HttpServletRequest request)  {

		HttpSession session=request.getSession();
		if(session.getAttribute("name")==null)
			
			return "first login kaa";
		session.invalidate();
		return "logout ayinav le";

			
		}
	
	@PostMapping("/orderitem/save")
	public String save(@RequestBody OrderItem oi,HttpServletRequest request) {
		//OrdertableService ots=new OrdertableService();
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return orderitemservice.save(oi);
			return "invalid access";
		
	}
	@GetMapping("orderitem/get/{id}")
	public Optional<OrderItem> get(@PathVariable int id,HttpServletRequest request ) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return orderitemservice.get(id);
			return null;
		
	}
	@DeleteMapping("/orderitem/delete/{id}")
	public String delete(@PathVariable int id,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return orderitemservice.delete(id);
			return "invalid access";
		
	}
	@PostMapping("/ordertable/save")
	public String saveProduct(@RequestBody Ordertable product,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return ordertableservice.save(product);
			return "invalid access";
		
	}
	@GetMapping("/ordertable/get/{id}")
	public Ordertable getProduct(@PathVariable int id,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return ordertableservice.get(id);
			return null;
		
	}
	@GetMapping("/ordertable/get")
	public List<Ordertable> getAllProduct(HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return ordertableservice.get();
			return null;
		
	}
	@PostMapping("/ordertable/update")
	public String updateProduct(@RequestBody Ordertable product,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return ordertableservice.update(product);
			return "invalid access";
		
	}
	@DeleteMapping("ordertable/delete/{id}")
	public String deleteProduct(@PathVariable int id,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
			return ordertableservice.delete(id);
			return "invalid access";
		
	}
	@GetMapping("cart/get")
	public Cart get(HttpServletRequest request ) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user") {
			int k=(int) session.getAttribute("role");
			return cartservice.findAllByuserId(k);}
			return null;
		
	}
	@PostMapping("/cartitem/save")
	public String saveCartItem(@RequestBody int pid,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("role")=="user")
		{
			int k=(int) session.getAttribute("id");
			System.out.println(k);
		int cartid=cartservice.findAllByuserId(k).getCartId();
		CartItem cartitem=new CartItem();
		cartitem.setCart(cartservice.get(cartid));
		cartitem.setProduct(productservice.getProduct(pid));
		cartitem.setQuantity(1);
		return cartitemservice.save(cartitem);}
			//return ordertableservice.save(product);}
			return "invalid access";
		
	}
	
//		if(role=="nouserexist")
//			return "login first to logout";
//		Cookie cookie=new Cookie("role", "nouserexist");
//		cookie.setPath("/");
//		cookie.setMaxAge(0);
//		respomanse.addCookie(cookie);
//		return "logged out successfully";
	}


