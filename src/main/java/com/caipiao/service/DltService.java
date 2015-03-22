package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.DltDetail;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月7日 下午3:11:07
 *email :hsqmobile@gmail.com
 */
public interface DltService {

	public DltDetail getLatest();
	public ArrayList<DltDetail> getPage(Page page);
	public DltDetail getById(long nid);
}
