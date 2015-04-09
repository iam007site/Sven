package com.hsq.sven.controller.web.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hsq.sven.domain.User;
import com.hsq.sven.model.ResultCode;
import com.hsq.sven.model.ResultModel;
import com.hsq.sven.model.ResultModelUtils;
import com.hsq.sven.model.SessionModel;
import com.hsq.sven.model.StatusModel;
import com.hsq.sven.service.UserService;
import com.hsq.sven.utils.EmailUtils;
import com.hsq.sven.utils.MD5Utils;

/*author:huangshanqi
 *time  :2015年1月31日 下午9:15:29
 *email :hsqmobile@gmail.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST, params = { "username", "email", "password" })
	public Object createUser(@ModelAttribute User user) {

		ResultModel resultModel = null;

		user = userService.createUser(user);
		if (user != null) {
			
			//send email
			String code = MD5Utils.encode2String(user.getUsername() + "$" + user.getEmail() + "$" + user.getEmailExpiredTime());

			StringBuilder content = new StringBuilder("");
			content.append("欢迎注册evilcoder.cn，点击以下完成邮箱验证!").append("\n");
			content.append("http://localhost:8080");
			content.append("/user/verify?email=").append(user.getEmail());
			content.append("&code=").append(code);
			content.append("\n");

			sendEmailAsynchronous("evilcoder.cn邮箱验证", content.toString(), user.getEmail());
			
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_CREATE_ERROR);
		}
		return resultModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "verify", method = RequestMethod.GET, params = { "email", "code" })
	public Object verifyEmail(@RequestParam("email") String email, @RequestParam("code") String code){
		
		ResultModel result = null;
		User user = userService.findUserByEmail(email);
		if(user == null){
			result = ResultModelUtils.getResultModelByCode(ResultCode.USER_NOT_EXISTS);
		}else{
			if(user.getEmailExpiredTime() < System.currentTimeMillis()){
				//过期
				result =  ResultModelUtils.getResultModelByCode(ResultCode.EMAIL_VERIFY_EXPIRED);
			}else{
				if(code.equals(MD5Utils.encode2String(user.getUsername() + "$" + user.getEmail() + "$" + user.getEmailExpiredTime()))){
					result =  ResultModelUtils.getResultModelByCode(ResultCode.OK);
					userService.updateEmailAuth(user.getId(), 1);
				}else{
					result =  ResultModelUtils.getResultModelByCode(ResultCode.EMAIL_VERIFY_CODE_ERROR);
				}
			}
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.POST, params = { "userId", "username" })
	public Object modifyName(@RequestParam("userId") int userId, @RequestParam("username") String username) {
		ResultModel resultModel = null;
		if (userService.updateUsername(userId, username)) {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_MODIFY_USERNAME_ERROR);
		}
		return resultModel;
	}

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.POST, params = { "userId", "password" })
	public Object modifyPassword(@RequestParam("userId") int userId, @RequestParam("password") String password) {
		ResultModel resultModel = null;
		if (userService.updatePassword(userId, password)) {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		} else {
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.USER_MODIFY_PASSWORD_ERROR);
		}
		return resultModel;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		SessionModel session = (SessionModel) subject.getPrincipal();
		if (session != null && !session.isExpired()) {
			subject.logout();
		}
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, params = { "email", "password" })
	public String loginShiro(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("rememberMe") boolean rememberMe,
			RedirectAttributes redirectAttributes) {

		ResultModel resultModel = new ResultModel();
		String host = request.getRemoteHost();
		AuthenticationToken authToken = this.createToken(email, password, rememberMe, host);
		// UsernamePasswordToken authToken = new UsernamePasswordToken(email,
		// password);
		try {
			Subject subject = SecurityUtils.getSubject();
			SessionModel loginedUser = (SessionModel) subject.getPrincipal();
			if (loginedUser == null) {
				subject.login(authToken);
				loginedUser = (SessionModel) subject.getPrincipal();
			}
			resultModel = ResultModelUtils.getResultModelByCode(ResultCode.OK);

			resultModel.setData(new StatusModel("登录成功"));
			// 更新登录时间
			// userService.updateLoginInfo(loginedUser.getUserId(), new Date());
			return "/home";
		} catch (UnknownAccountException ex) {// 用户名没有找到。
			System.err.println("error==================用户名没有找到。");
			redirectAttributes.addFlashAttribute("message", "用户名没有找到!");
			return "redirect:/user/login";
		} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配。
			redirectAttributes.addFlashAttribute("message", "用户名密码不匹配!");
			return "redirect:/user/login";
		} catch (AuthenticationException e) {// 其他的登录错误
			redirectAttributes.addFlashAttribute("message", "用户名密码不匹配!");
			return "redirect:/user/login";
		}

	}

	protected AuthenticationToken createToken(String username, String password, boolean rememberMe, String host) {
		return new UsernamePasswordToken(username, password, rememberMe, host);
	}

	protected void sendEmailAsynchronous(final String subject, final String content, final String to) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					emailUtils.sendMail(subject, content, to);
				} catch (Exception e) {
				}
			}
		});
	}
}
