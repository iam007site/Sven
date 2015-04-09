package com.hsq.sven.controller.web.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*author:huangshanqi
 *time  :2014年10月10日 上午9:06:27
 *email :hsqmobile@gmail.com
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsq.sven.service.UserService;
import com.hsq.sven.utils.RegexUtils;

@Controller(value = "WebCheckController")
@RequestMapping(value = "check/user/")
public class CheckController {
	/*网页端注册检验控制器,用户ajax 异步请求，直接返回true or false*/
	
	@Autowired
	private UserService userService;
    
	
	/**web端检验邮箱是否可用,可用返回true,否则返回false
	 * @param request
	 * @param email
	 * @return ResultModel
	 * @throws IOException 
	 */
	@RequestMapping(value = "email", method = RequestMethod.GET,params = {"email"})
	public void wCheck(HttpServletRequest request, HttpServletResponse response,@RequestParam("email") String email) throws IOException {
		
		if (RegexUtils.checkEmail(email)) {
			if (userService.findUserByEmail(email)!=null) {
				response.getOutputStream().print(false);
			} else {
				response.getOutputStream().print(true);
			}
		}else {
			response.getOutputStream().print(false);
		}
	}
	
	/**web端检验手机号是否可用,可用返回true,否则返回false
	 * @param request
	 * @param mobile
	 * @return ResultModel
	 * @throws IOException 
	 */
	/*
	@RequestMapping(value = "mobile", method = RequestMethod.GET,params = {"mobile"})
	public void checkEmail(HttpServletRequest request, HttpServletResponse response,@RequestParam("mobile") String mobile) throws IOException {
		
		if (RegexUtils.checkPhone(mobile)) {
			if (userService.isMobileExisted(mobile)) {
				response.getOutputStream().print(false);
			} else {
				response.getOutputStream().print(true);
			}
		}else {
			response.getOutputStream().print(false);
		}
	}
	*/
	
	/**web端检验用户名是否可用,可用返回true,否则返回false
	 * @param request
	 * @param username
	 * @return ResultModel
	 * @throws IOException 
	 */
	@RequestMapping(value = "username", method = RequestMethod.GET,params = {"username"})
	public void checkUsername(HttpServletRequest request, HttpServletResponse response,@RequestParam("username") String username) throws IOException {
		
		if (RegexUtils.checkName(username)) {
			if (userService.findUserByUserName(username)!=null) {
				response.getOutputStream().print(false);
			} else {
				response.getOutputStream().print(true);
			}
		}else {
			response.getOutputStream().print(false);
		}
	}
	
	
	
	
}
