package com.vikas.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.entity.User;
import com.vikas.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public String saveUser( User u) {
		ur.save(u);
		return "User registered Successfully";
	}
	public  User getUser(int id) {
			User user =ur.findById(id).get();
				return user;
	}
	public String updateUser(User u) {
		User user=ur.findById(u.getUserId()).orElse(null);
		if(user!=null) {
			user.setUserMail(u.getUserMail());
			user.setUserName(u.getUserName());
			user.setUserPassword(u.getUserPassword());
			ur.save(user);
			return "Success";
		}
		else 
			return "Fali";
	}
	public String deleteUser(int id) {
		User user=ur.findById(id).orElse(null);
		if(user!=null) {
			ur.deleteById(id);
			return "deleted";
		}
		else 
			return "fail";
	}
	public List<User> getAllProducts(){
		return ur.findAll();
	}
}
