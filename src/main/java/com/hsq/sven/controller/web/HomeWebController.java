package com.hsq.sven.controller.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.sven.common.Constants;
import com.hsq.sven.domain.User;
import com.hsq.sven.domain.blog.BlogCategoryStatistic;
import com.hsq.sven.domain.blog.item.BlogItem;
import com.hsq.sven.service.UserService;
import com.hsq.sven.service.blog.BlogService;

/*author:huangshanqi
 *time  :2015年3月28日 上午10:50:01
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping("/")
public class HomeWebController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="{username}",method=RequestMethod.GET)
	public String userHome(@PathVariable("username") String username,HttpServletRequest request){
		User user = userService.findUserByUserName(username);
		if(user == null){
			return "blog/blog_not_found";
		}else{
			
			request.setAttribute("username", username);
			return "blog/blog_home";
		}
		
	}
	
	@RequestMapping(value="{username}/blog/{pageNum}",method=RequestMethod.GET)
	public Object userBlogPage(@PathVariable("username") String username,@PathVariable("pageNum") int pageNum,
			HttpServletRequest request){
		User user = userService.findUserByUserName(username);
		if(user == null){
			return "blog/blog_not_found";
		}else{
			if(pageNum <1){
				pageNum =1;
			}
			int totalBlog = blogService.getUserTotalBlogNum(user.getId());
			int totalPage = (totalBlog % Constants.BlogPageSize == 0)?(totalBlog/Constants.BlogPageSize):(totalBlog/Constants.BlogPageSize + 1);
			if(pageNum > totalPage){
				pageNum = totalPage;
			}
			
			ArrayList<BlogItem> blogList = blogService.getUserBlogByOffset(user.getId(), (pageNum-1)*Constants.BlogPageSize, Constants.BlogPageSize);
			////
			ArrayList<BlogCategoryStatistic> categoryList = blogService.getUserBlogCategoryStatistic(user.getId());
			
			request.setAttribute("blogList", blogList);
			request.setAttribute("categoryList", categoryList);
//			return blogList;
			return "blog/blog_home";
		}
		
	}
	
	
	
}
