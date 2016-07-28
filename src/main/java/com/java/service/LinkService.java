package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.entity.Link;

public interface LinkService {

	public List<Link> list(Map<String, Object> map);
}
