package com.app2.backend02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app2.backend02.entity.User;
import com.app2.backend02.repository.UserRepository;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserService {
	@Autowired
	UserRepository userRepository;

	@GetMapping(path ="/buscar")
	public List<User>getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public User saveUser(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
	@DeleteMapping(path ="/eliminar/{correo_user}")
	public void deleteUser(@PathVariable ("correo_user")String correo_user) {
		
		Optional<User> user;
		
		user = userRepository.findById(correo_user);
		
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
		
	}
	
	@PostMapping(path ="/login")
	public User login(@RequestBody User user) {
		
		List<User> users = userRepository.findByCorreoUserAndPassword(user.getCorreo_user(), user.getPassword());
		
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}
	
}
