package com.myapp.rest.webservices.domain;

import java.util.Date;

public class Post {

	private String message;
	private Date timestamp;
	private Integer userId;
	private Integer postId;

	public Post() {

	}

	public Post(Integer postid,String message, Date timestamp, Integer userId) {
		super();
		this.postId = postid;
		this.message = message;
		this.timestamp = timestamp;
		this.userId = userId;
	}

	
	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Post [message=" + message + ", timestamp=" + timestamp + "]";
	}
}
