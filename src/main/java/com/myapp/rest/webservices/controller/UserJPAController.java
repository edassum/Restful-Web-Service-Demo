package com.myapp.rest.webservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.rest.webservices.domain.User;
import com.myapp.rest.webservices.exceptions.UserNotFoundException;
import com.myapp.rest.webservices.repo.UserRepository;
import com.myapp.rest.webservices.service.UserDaoService;

@RestController
public class UserJPAController {

	@Autowired
	private UserRepository userRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/jpa/users")
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@GetMapping(value = "/jpa/users/{id}")
	public User findUser(@PathVariable int id) {
		Optional<User> userVal = userRepo.findById(id);
		if (!(userVal.isPresent())) {
			throw new UserNotFoundException("User with id-" + id + " not found");
		}
		User user = userVal.get();
		return user;
	}
}
