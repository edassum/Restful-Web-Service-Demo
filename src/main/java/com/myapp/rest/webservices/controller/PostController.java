package com.myapp.rest.webservices.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myapp.rest.webservices.domain.Post;
import com.myapp.rest.webservices.exceptions.PostNotFoundException;
import com.myapp.rest.webservices.service.PostDaoService;

@Controller
public class PostController {

	@Autowired
	PostDaoService postService;

	@RequestMapping(value = "/users/{id}/posts", method = RequestMethod.GET)
	@ResponseBody
	public List<Post> findAllPostsForAUser(@PathVariable Integer id) {
		return postService.findAll(id);
	}

	@RequestMapping(value = "/users/{id}/posts/{post_id}", method = RequestMethod.GET)
	@ResponseBody
	public Post findAPostForAUser(@PathVariable int id, @PathVariable int post_id) {
		Post post = postService.findOne(id, post_id);
		if (post == null) {
			throw new PostNotFoundException("No post for the id is found");
		} else
			return post;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createAPostForAUser(@RequestBody Post post, @PathVariable Integer id) {
		Post savedPost = postService.save(post, id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPost.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
