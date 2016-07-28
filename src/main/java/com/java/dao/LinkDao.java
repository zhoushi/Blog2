package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.entity.Link;

public interface LinkDao {
	
	public List<Link> list(Map<String, Object> map);

}
