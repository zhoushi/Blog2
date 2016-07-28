package com.java.controller.admin;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.java.entity.Blog;
import com.java.service.BlogService;
import com.java.util.ResponseUtil;

/**
 * blog控制类
 * @author zhou
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	
	@RequestMapping("/save")
	public String save(Blog blog,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		if(blog.getId()==null){
			resultTotal=blogService.add(blog);
		}else{
			
		}
		JSONObject result = new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		
		return null;
	}
}
