package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.entity.Comment;

public interface CommentDao {
	/**
	 * 取出评论
	 * @param map
	 * @return
	 */
	public List<Comment> list(Map<String, Object> map);
	
	/**
	 * 添加Comment
	 * @param comment
	 * @return
	 */
	public int add(Comment comment);

}
