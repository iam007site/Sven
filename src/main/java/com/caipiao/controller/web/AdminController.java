package com.caipiao.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*author:huangshanqi
 *time  :2015年3月8日 下午5:18:23
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

	@RequestMapping("")
	public String admin() {
		return "redirect:/admin/ad/1";
	}

}
