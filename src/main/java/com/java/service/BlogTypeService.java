package com.java.service;

import java.util.List;

import com.java.entity.BlogType;

public interface BlogTypeService {

	public List<BlogType> countList();
	
	/**
	 * 通过id查找博客类型实体
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);

}
