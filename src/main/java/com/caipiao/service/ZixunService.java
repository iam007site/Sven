package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.ZixunDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.domain.item.ZixunItem;

/*author:huangshanqi
 *time  :2015年3月7日 下午3:11:07
 *email :hsqmobile@gmail.com
 */
public interface ZixunService {

	public ZixunDetail getZixunDetail(long zxId);
	public ArrayList<ZixunItem> getZixunPageByType(Page page);
	public ArrayList<ZixunItem> getPageByOffset(Page page);
	public long create(ZixunDetail zixun);
	public long getTotalNum();
	public boolean deleteById(long nid);
	public boolean update(ZixunDetail zixun);
}
