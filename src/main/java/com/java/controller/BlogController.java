package com.java.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.java.entity.Blog;
import com.java.lucene.BlogIndex;
import com.java.service.BlogService;
import com.java.service.CommentService;
import com.java.util.StringUtil;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	
	@Resource
	private CommentService commentService;
	private BlogIndex blogIndex = new BlogIndex();
	
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		Blog blog=blogService.findById(id);
		String keyWords = blog.getKeyWord();
		
		if(StringUtil.isNotEmpty(keyWords)){
			String arr[]=keyWords.split(" ");
			//用Arrays.asList方法将其数组转换成List
			mav.addObject("keyWords", StringUtil.filterWhite(Arrays.asList(arr)));
		}else{
			mav.addObject("keyWords",null);
		}
		
		mav.addObject("blog",blog);
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		
		mav.addObject("commentList",commentService.list(map));
		mav.addObject("pageCode", this.getUpAndDownPageCode(blogService.getLastBlog(id), blogService.getNextBlog(id), request.getServletContext().getContextPath()));
		mav.addObject("pageTitle", blog.getTitle()+"java开源博客系统");
		mav.addObject("mainPage", "foreground/blog/view.jsp");
		mav.setViewName("mainTemp");
		return mav;

	}
	
	/**
	 * 获取上一篇博客和下一篇博客
	 * @param lastBlog
	 * @param nextBlog
	 * @param projectContext
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}
			
		if(nextBlog==null || nextBlog.getId()==null){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}

	/**
	 * search
	 */
	@RequestMapping("/q")
	public ModelAndView search(@RequestParam(value="q",required=false) String q)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "搜索关键字'"+q+"'结果页面_java开源博客系统");
		mav.addObject("mainPage", "foreground/blog/result.jsp");
		List<Blog> blogList=blogIndex.searchBlog(q);
		mav.addObject("blogList", blogList);
		mav.addObject("q", q);
		mav.addObject("resultTotal", blogList.size());
		mav.setViewName("mainTemp");
		return mav;
		
	}

}
