package com.hsq.sven.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.sven.domain.blog.Blog;
import com.hsq.sven.form.NewBlogForm;

/*author:huangshanqi
 *time  :2015年3月26日 下午8:28:51
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value="user/blog")
public class BlogWebController {
	
	@RequestMapping(value="new",method=RequestMethod.GET)
	public String newBlogGet(){
		return "blog/new_blog";
	}
	
	@RequestMapping(value="new",method=RequestMethod.POST)
	@ResponseBody
	public Object newBlogPost(@ModelAttribute NewBlogForm form){
		
		
		return form;
	}

}
