package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.SsqDetail;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月7日 下午3:11:07
 *email :hsqmobile@gmail.com
 */
public interface SsqService {

	public SsqDetail getLatest();
	public ArrayList<SsqDetail> getPage(Page page);
	public SsqDetail getById(long nid);
}
