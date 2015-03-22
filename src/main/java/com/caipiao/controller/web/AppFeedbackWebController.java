package com.caipiao.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caipiao.domain.base.Page;
import com.caipiao.service.AppFeedbackService;

/*author:huangshanqi
 *time  :2015年3月8日 下午12:22:24
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value="admin/feedback")
public class AppFeedbackWebController {

	@Autowired
	private AppFeedbackService appFeedbackService;
	
	@RequestMapping(value="{pageNum}",method=RequestMethod.GET)
	public String getPage(@PathVariable("pageNum") int pageNum,HttpServletRequest request){
		
		int pageSize = 20;
		
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setOffset((pageNum-1)*pageSize);
		request.setAttribute("list", appFeedbackService.getPage(page));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageSize", pageSize);
		long totalNum = appFeedbackService.getTotalNum();
		
		request.setAttribute("totalPage", (totalNum%pageSize == 0)?(totalNum/pageSize):(totalNum/pageSize + 1));
		
	  return "admin/feedback";
	}
	

	
}
