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
import com.caipiao.service.Fc3dService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月7日 下午2:57:10
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value="api/fc3d")
public class Fc3dApiController {

	@Autowired
	private Fc3dService fc3dService;
	
	
	@RequestMapping(value="latest",method=RequestMethod.GET)
	public Object getFc3dLatest(){

		ResultModel result = new ResultModel();
		
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
			result.setData(fc3dService.getLatest());
		
		return result;
	}
	
	
	
	@RequestMapping(value="history",method=RequestMethod.GET,params={"pageSize","lastTerm"})
	public Object getFc3dHistory(@RequestParam("pageSize") int pageSize,@RequestParam("lastTerm") long lastTerm){

		ResultModel result = new ResultModel();
		if(ParamUtils.isNotEmpty(pageSize,lastTerm)){
			if(lastTerm ==0){
				lastTerm = 99999999L;
			}
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
			Page page = new Page();
			page.setPageSize(pageSize);
			Map map = new HashMap<String, Object>();
			map.put("lastTerm", lastTerm);
			page.setCondition(map);
			page.setCondition(map);
			result.setData(fc3dService.getPage(page));
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.Fc3d_GetHistoryList_Error);
		}
		return result;
	}
}
