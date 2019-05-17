package com.myapp.rest.webservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myapp.rest.webservices.domain.Post;

@Component
public class PostDaoService {

	private static List<Post> posts = new ArrayList<>();

	private static int postsCount = 8;

	static {
		posts.add(new Post(1, "Hi how are you Sumit", new Date(), 1));
		posts.add(new Post(2, "Hi how are you Priyanku", new Date(), 2));
		posts.add(new Post(3, "Hi how are you Suman", new Date(), 3));
		posts.add(new Post(4, "Hi how are you Dwaipayan", new Date(), 4));
		posts.add(new Post(5, "Hi how are you Subho", new Date(), 1));
		posts.add(new Post(6, "Hi how are you Chyangi", new Date(), 2));
		posts.add(new Post(7, "Hi how are you Molly", new Date(), 3));
		posts.add(new Post(8, "Hi how are you Jim", new Date(), 4));

	}

	public List<Post> findAll(int id) {
		ArrayList<Post> sublist = new ArrayList<Post>();
		for (Post post : posts) {
			if (post.getUserId() == id) {
				sublist.add(post);
			}
		}
		return sublist;
	}

	public Post findOne(int user_id, int post_id) {

		Post postVal = null;
		
		for (Post post : posts) {
			if (post.getPostId() == post_id && post.getUserId() == user_id) {
				postVal = post;
			} 
		}
		return postVal;

	}

	public Post save(Post post, int id) {
		if (post != null) {
			int post_id = ++postsCount;
			post.setPostId(post_id);
			post.setUserId(id);
			posts.add(post);
		}
		return post;
	}
}
