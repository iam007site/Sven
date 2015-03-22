package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.Advertising;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月8日 上午10:55:29
 *email :hsqmobile@gmail.com
 */
public interface AdvertisingService {

	public long create(Advertising entity);
	public Advertising findById(long nid);
	public boolean deleteById(long nid);
	public boolean update(Advertising entity);
	public ArrayList<Advertising> getPage(Page page);
	public ArrayList<Advertising> getPageByOffset(Page page);
	public long getTotalNum();
}
