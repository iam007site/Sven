package com.caipiao.controller.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caipiao.domain.AppFeedback;
import com.caipiao.model.ResultCode;
import com.caipiao.model.ResultModel;
import com.caipiao.model.ResultModelUtils;
import com.caipiao.model.StatusModel;
import com.caipiao.service.AppFeedbackService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月8日 下午12:22:24
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value="api/feedback")
public class AppFeedbackApiController {

	@Autowired
	private AppFeedbackService appFeedbackService;
	
	@RequestMapping(value="new",method=RequestMethod.POST,params = {"device","content"})
	public Object getDetail(@RequestParam("device") String device,@RequestParam("content") String content){
		ResultModel result = new ResultModel();
		if(ParamUtils.isNotEmpty(device,content)){
			AppFeedback feedback = new AppFeedback();
			feedback.setContent(content);
			feedback.setDevice(device);
			feedback.setPublishTime(new Date());
			if(appFeedbackService.create(feedback)>0){
				result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
				result.setData(new StatusModel("ok"));
			}else{
				result = ResultModelUtils.getResultModelByCode(ResultCode.AppFeedback_Create_Error);
			}
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.AppFeedback_Create_Error);
		}
	  return result;
	}
	
}
