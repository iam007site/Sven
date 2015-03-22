package com.caipiao.controller.api;

import java.util.Date;
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
import com.caipiao.service.ZixunService;
import com.caipiao.utils.ParamUtils;

/*author:huangshanqi
 *time  :2015年3月7日 下午2:57:10
 *email :hsqmobile@gmail.com
 */
@RestController
@RequestMapping(value = "api/zx")
public class ZixunApiController {

	@Autowired
	private ZixunService zixunService;

	
	@RequestMapping(value = "detail", method = RequestMethod.GET, params = { "zxId" })
	public Object getZixunDetail(@RequestParam("zxId") Long zxId) {

		ResultModel result = new ResultModel();
		if (zxId == null) {
			result = ResultModelUtils.getResultModelByCode(ResultCode.Zixun_Detail_Error);
		} else {
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
			result.setData(zixunService.getZixunDetail(zxId));
		}
		return result;
	}

	
	@RequestMapping(value = "getPageByType", method = RequestMethod.GET,params={"pageSize","lastTime","type"})
	public Object getZixun(@RequestParam("pageSize") int pageSize,
			@RequestParam("lastTime") long lastTime ,@RequestParam("type") String caipiaoType) {

		ResultModel result = new ResultModel();
		if(ParamUtils.isNotEmpty(pageSize,lastTime,caipiaoType)){
			
			System.out.println("now============" + new Date().getTime());
			result = ResultModelUtils.getResultModelByCode(ResultCode.OK);
			Page page = new Page();
			page.setPageSize(pageSize);
			Map map = new HashMap<String, Object>();
			if(lastTime == 0){
				map.put("lastTime", new Date());
			}else{
				map.put("lastTime", new Date(lastTime));
			}
			map.put("caipiaoType", caipiaoType);
			page.setCondition(map);
			result.setData(zixunService.getZixunPageByType(page));
		}else{
			result = ResultModelUtils.getResultModelByCode(ResultCode.Zixun_GetList_Error);
		}
		return result;
	}
}
