package com.caipiao.dao;

import java.util.ArrayList;

import com.caipiao.domain.ZixunDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.domain.item.ZixunItem;
/*author:huangshanqi
 *time  :2015年3月7日 下午2:46:52
 *email :hsqmobile@gmail.com
 */
public interface ZixunDao {

	public ZixunDetail getById(long zixunId);
	public ArrayList<ZixunItem> getZixunPageByType(Page page);
	public ArrayList<ZixunItem> getPageByOffset(Page page);
	public int deleteById(long nid);
	public long create(ZixunDetail zixun);
	public long getTotalNum();
    public int update(ZixunDetail zixun);	
}
