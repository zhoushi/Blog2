package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.Comment;

public interface CommentService {

	public List<Comment> list(Map<String, Object> map);
	
	public int add(Comment comment);
}
