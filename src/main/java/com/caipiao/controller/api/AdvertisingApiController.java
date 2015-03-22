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
import com.caipiao.service.AdvertisingService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月8日 上午11:09:21
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value="api/ad")
public class AdvertisingApiController {

	@Autowired
	private AdvertisingService advertisingService;
	
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
			result.setData(advertisingService.getPage(page));
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.Ad_getList_Error);
		}
		
	  return result;
	}
}
