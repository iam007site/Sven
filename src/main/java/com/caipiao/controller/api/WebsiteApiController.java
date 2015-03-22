package com.caipiao.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caipiao.domain.base.Page;
import com.caipiao.model.ResultCode;
import com.caipiao.model.ResultModel;
import com.caipiao.model.ResultModelUtils;
import com.caipiao.service.WebsiteService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月8日 下午12:22:24
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value="api/websit")
public class WebsiteApiController {

	@Autowired
	private WebsiteService websiteService;
	
	@RequestMapping(value="getPage",method=RequestMethod.GET,params={"pageSize","lastId"})
	public Object getPage(@RequestParam("pageSize") int pageSize,@RequestParam("lastId") long lastId){
		ResultModel result = new ResultModel();
		if(ParamUtils.isNotEmpty(pageSize,lastId)){
			
			Page page = new Page();
			page.setPageSize(pageSize);
			Map map = new HashMap<String,Object>();
			map.put("lastId",lastId);
			page.setCondition(map);
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
			result.setData(websiteService.getPage(page));
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.Website_getList_Error);
		}
		
	  return result;
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET,params={"websiteId"})
	public Object getDetail(@RequestParam("websiteId") long websiteId){
		ResultModel result = new ResultModel();
		if(ParamUtils.isNotEmpty(websiteId)){
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
			result.setData(websiteService.findById(websiteId));
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.Website_getList_Error);
		}
		
	  return result;
	}
	
}
