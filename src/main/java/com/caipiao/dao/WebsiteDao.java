package com.caipiao.dao;

import java.util.ArrayList;

import com.caipiao.dao.base.BaseDao;
import com.caipiao.domain.Website;
import com.caipiao.domain.base.Page;
import com.caipiao.domain.item.WebsiteItem;

/*author:huangshanqi
 *time  :2015年3月8日 上午12:15:43
 *email :hsqmobile@gmail.com
 */
public interface WebsiteDao extends BaseDao<Website> {

	public ArrayList<WebsiteItem> getPage(Page page);
	public Website fingByUrl(String url);
	public ArrayList<WebsiteItem> getPageByOffset(Page page);
	public long getTotalNum();
}
