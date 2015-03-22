package com.hsq.sven.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.sven.domain.User;
import com.hsq.sven.model.ResultCode;
import com.hsq.sven.model.ResultModel;
import com.hsq.sven.model.ResultModelUtils;
import com.hsq.sven.model.SessionModel;
import com.hsq.sven.service.UserService;

	

/*author:huangshanqi
 *time  :2015年1月31日 下午9:15:29
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "register",method = RequestMethod.POST,params = {"username","email","password"})
	public Object createUser(@ModelAttribute User user){
		
		ResultModel resultModel = null;
		
		if(userService.createUser(user) > 0 ){
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_CREATE_ERROR);
		}
		return resultModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "modify",method = RequestMethod.POST,params = {"userId","username"})
	public Object modifyName(@RequestParam("userId") int userId,@RequestParam("username") String username){
		ResultModel resultModel = null;
		if(userService.updateUsername(userId, username)){
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_MODIFY_USERNAME_ERROR);
		}
		return resultModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "modify",method = RequestMethod.POST,params = {"userId","password"})
	public Object modifyPassword(@RequestParam("userId") int userId,@RequestParam("password") String password){
		ResultModel resultModel = null;
		if(userService.updatePassword(userId, password)){
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		}else{
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_MODIFY_PASSWORD_ERROR);
		}
		return resultModel;
	}

	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		SessionModel session = (SessionModel) subject.getPrincipal();
		if (session != null && !session.isExpired()) {
			subject.logout();
		}
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, params = {
			"email", "password" })
	public String loginShiro(HttpServletRequest request,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
//		
//		String result = "";
//		ResultModel resultModel = new ResultModel();
//		boolean rememberMe = false;
//		String host = request.getRemoteHost();
////		AuthenticationToken authToken = this.createToken(email, password,rememberMe, host);
//		UsernamePasswordToken authToken = new UsernamePasswordToken(email, password);
//		try {
//			Subject subject = SecurityUtils.getSubject();
//			SessionModel loginedUser = (SessionModel) subject
//					.getPrincipal();
//			if (loginedUser == null) {
//			System.out.println("==================before login");
//				subject.login(authToken);
//				System.out.println("==================after login");
//				 loginedUser = (SessionModel) subject.getPrincipal();
//			}
//			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
//
//			resultModel.setData(new StatusModel("登录成功"));
//			//更新登录时间
//			//userService.updateLoginInfo(loginedUser.getUserId(), new Date());
//			result = "/home";
//		} catch (UnknownAccountException ex) {//用户名没有找到。  
//			System.err.println("error==================用户名没有找到。");
//		} catch (IncorrectCredentialsException ex) {//用户名密码不匹配。  
//			System.err.println("error==================用户名密码不匹配");
//		}catch (AuthenticationException e) {//其他的登录错误  
//			System.err.println("error==================用户名密码不匹配");
//		}  

		return "user/login";
	}
	
	
	protected AuthenticationToken createToken(String username, String password,
			boolean rememberMe, String host) {
		return new UsernamePasswordToken(username, password, rememberMe, host);
	}
}
