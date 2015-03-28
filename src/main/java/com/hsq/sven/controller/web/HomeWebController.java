package com.hsq.sven.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*author:huangshanqi
 *time  :2015年3月28日 上午10:50:01
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping("/")
public class HomeWebController {

	@RequestMapping(value="home",method=RequestMethod.GET)
	public String home(){
		return "home";
	}
}
