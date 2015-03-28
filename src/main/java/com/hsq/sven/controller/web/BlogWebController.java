package com.hsq.sven.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.sven.form.NewBlogForm;
import com.hsq.sven.model.ResultCode;
import com.hsq.sven.model.ResultModel;
import com.hsq.sven.model.ResultModelUtils;
import com.hsq.sven.service.blog.BlogService;

/*author:huangshanqi
 *time  :2015年3月26日 下午8:28:51
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value="user/blog")
public class BlogWebController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="new",method=RequestMethod.GET)
	public String newBlogGet(){
		return "blog/new_blog";
	}
	
	@RequestMapping(value="new",method=RequestMethod.POST)
	@ResponseBody
	public Object newBlogPost(@ModelAttribute NewBlogForm form){
		
		ResultModel result;
		if(blogService.newBlog(form)){
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.Create_Blog_Error);
		}
		
		return result;
	}

}
