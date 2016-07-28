package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.BlogTypeDao;
import com.java.entity.BlogType;
import com.java.service.BlogTypeService;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeDao blogTypeDao;
	
	public List<BlogType> countList() {
		
		return blogTypeDao.countList();
	}

	public BlogType findById(Integer id) {
		
		return blogTypeDao.findById(id);
	}

}
