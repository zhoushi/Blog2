package com.java.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.BloggerDao;
import com.java.dao.LinkDao;
import com.java.entity.Link;
import com.java.service.LinkService;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkDao linkDao;
	
	public List<Link> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return linkDao.list(map);
	}

}
