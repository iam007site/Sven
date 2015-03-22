package com.caipiao.controller.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caipiao.domain.WebsiteComment;
import com.caipiao.domain.base.Page;
import com.caipiao.model.ResultCode;
import com.caipiao.model.ResultModel;
import com.caipiao.model.ResultModelUtils;
import com.caipiao.model.StatusModel;
import com.caipiao.service.WebsiteCommentService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月8日 下午1:29:01
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value = "api/website/comment")
public class WebsiteCommentApiController {

	@Autowired
	private WebsiteCommentService websiteCommentService;

	@RequestMapping(value = "getAll", method = RequestMethod.GET, params = { "websiteId"})
	public Object getPage(@RequestParam("websiteId") long websiteId ) {

		ResultModel result = new ResultModel();

		result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
		result.setData(websiteCommentService.getAll(websiteId));

		return result;
	}

	@RequestMapping(value = "new", method = RequestMethod.POST, params = { "username", "websiteId", "content" })
//	public Object getPage(@ModelAttribute WebsiteComment comment) {
		public Object getPage(@RequestParam("username") String username,@RequestParam("websiteId") long websiteId,@RequestParam("content") String content) {

		ResultModel result = new ResultModel();

//		if (ParamUtils.isNotEmpty(comment.getUsername(), comment.getContent(), comment.getWebsiteId())) {
			if (ParamUtils.isNotEmpty(username,websiteId,content)) {
				WebsiteComment comment = new WebsiteComment();
				comment.setUsername(username);
				comment.setWebsiteId(websiteId);
				comment.setContent(content);
			    comment.setCreateTime(new Date());
			if (websiteCommentService.create(comment) > 0) {
				result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
				result.setData(new StatusModel("ok"));
			} else {
				result = ResultModelUtils.getResultModelByCode(ResultCode.Website_Commment_Error);
			}
		} else {
			result = ResultModelUtils.getResultModelByCode(ResultCode.Website_Commment_Error);
		}

		return result;
	}

}
