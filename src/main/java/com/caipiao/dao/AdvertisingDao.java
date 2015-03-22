package com.caipiao.dao;

import java.util.ArrayList;

import com.caipiao.dao.base.BaseDao;
import com.caipiao.domain.Advertising;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月8日 上午12:15:14
 *email :hsqmobile@gmail.com
 */
public interface AdvertisingDao extends BaseDao<Advertising> {

	public ArrayList<Advertising> getPage(Page page);
	public ArrayList<Advertising> getPageByOffset(Page page);
	public Advertising fingByUrl(String url);
	public long getTotalNum();
}
