package com.cg.RestfulService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.RestfulService.entity.User;
import com.cg.RestfulService.exception.UserNotFoundException;
import com.cg.RestfulService.service.IService;
import com.cg.RestfulService.service.UserService;

@RestController // @Controller
public class UserResource {

	@Autowired
	private IService userService;

	//@RequestMapping(value = "/users", method = RequestMethod.GET)
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers() of UserResource");
		return userService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable("id") Integer id)throws UserNotFoundException {
		System.out.println("Inside retrieveUser() with id "+id);
		User user=userService.findOne(id);
		if(user==null)
		{
			UserNotFoundException u= new UserNotFoundException("User with "+id+" Not Found");
			throw u;
		}
		//System.out.println("returned user " + user);
		return user;
	}
	
	@PostMapping(path="/users")
	
	public void createUser(@RequestBody User user) {
		System.out.println("Inside createUser of Controller");
		User usr=userService.save(user);		
	}
	
	@DeleteMapping(path="/deleteusers/{id}")
	public void deleteUser(@PathVariable int id)throws UserNotFoundException {
		userService.deleteOneUser(id);
		
	}
	
	@GetMapping(path = "/users/byName/{name}")
	public User retrieveUserByName(@PathVariable("name") String username) throws UserNotFoundException {
		System.out.println("Inside retrieveUserByName(String username) of UserResource");

		User user = userService.findByName(username);
		System.out.println("Returned user is " + user);

		// Throw user defined exception
		if (user == null) {
			UserNotFoundException userNotFound = new UserNotFoundException("User not found");
			throw userNotFound;
		}

		return user;
	}
}
