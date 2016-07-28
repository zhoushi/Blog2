package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.entity.Blog;


public interface BlogDao {

	
	public List<Blog> countList();
	
	public List<Blog> list(Map<String, Object> map);
	
	public Long getTotal(Map<String, Object> map);
	
	public Blog findById(Integer id);
	
	public int update(Blog blog);
	
	/**
	 * 最后一篇博文
	 * @param id
	 * @return
	 */
	public Blog getLastBlog(Integer id);
	
	/**
	 * 下一篇博文
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);
	
	/**
	 * 添加博文
	 */
	public int add(Blog blog);
}
