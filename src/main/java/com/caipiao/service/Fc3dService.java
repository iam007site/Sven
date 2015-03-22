package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.Fc3dDetail;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月7日 下午3:11:07
 *email :hsqmobile@gmail.com
 */
public interface Fc3dService {

	public Fc3dDetail getLatest();
	public ArrayList<Fc3dDetail> getPage(Page page);
	public Fc3dDetail getById(long nid);
}
