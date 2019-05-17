package com.myapp.rest.webservices.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myapp.rest.webservices.domain.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();

	private static int userscount = 4;

	static {
		users.add(new User(1, "Sumit", new Date()));
		users.add(new User(2, "Priyanku", new Date()));
		users.add(new User(3, "Dwaipayan", new Date()));
		users.add(new User(4, "Mahul", new Date()));
	}

	public List<User> findAll() {
		return users;

	}

	public User findOne(int id) {
		User userVal = null;
		for (User user : users) {
			if (user.getId() == id) {
				userVal = user;
			}
		}
		return userVal;
	}

	public User save(User user) {
		if (user.getId() == null) {
			int id = ++userscount;
			user.setId(id);
		}
		users.add(user);
		return user;
	}

}
