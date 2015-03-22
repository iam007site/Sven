package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.Website;
import com.caipiao.domain.base.Page;
import com.caipiao.domain.item.WebsiteItem;

/*author:huangshanqi
 *time  :2015年3月8日 上午10:55:29
 *email :hsqmobile@gmail.com
 */
public interface WebsiteService {

	public long create(Website entity);
	public Website findById(long nid);
	public boolean deleteById(long nid);
	public boolean update(Website entity);
	public ArrayList<WebsiteItem> getPage(Page page);
	public ArrayList<WebsiteItem> getPageByOffset(Page page);
	public long getTotalNum();
}
