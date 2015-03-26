package com.hsq.sven.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*author:huangshanqi
 *time  :2015年3月26日 下午8:28:51
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value="user/blog")
public class BlogWebController {
	
	@RequestMapping(value="new",method=RequestMethod.GET)
	public String newBlog(){
		return "blog/new_blog";
	}

}
