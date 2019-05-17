package com.myapp.rest.webservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myapp.rest.webservices.domain.User;
import com.myapp.rest.webservices.exceptions.UserNotFoundException;
import com.myapp.rest.webservices.service.UserDaoService;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@GetMapping(value = "/users/{id}")
	public User findUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("User with id-"+id+" not found");
		}
		return user;
	}
}
