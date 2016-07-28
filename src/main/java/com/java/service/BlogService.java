package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.Blog;


public interface BlogService {


	public List<Blog> countList();
	
	public List<Blog> list(Map<String, Object> map);
	
	public Long getTotal(Map<String, Object> map);
	
	public Blog findById(Integer id);
	
	public int update(Blog blog);
	
	public Blog getLastBlog(Integer id);
	
	public Blog getNextBlog(Integer id);
	
	public int add(Blog blog);
}
