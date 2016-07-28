package com.java.service.impl;
import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.java.dao.CommentDao;
import com.java.entity.Comment;
import com.java.service.CommentService;

@Service("CommentService")
public class CommentServiceImpl implements CommentService{
	
	@Resource
	private CommentDao commentDao;

	public List<Comment> list(Map<String, Object> map) {
		
		return commentDao.list(map);
	}

	public int add(Comment comment) {
		
		return commentDao.add(comment);
	}

}
