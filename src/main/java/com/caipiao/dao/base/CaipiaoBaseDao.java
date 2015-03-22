package com.caipiao.dao.base;

import java.io.Serializable;
import java.util.ArrayList;

import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月7日 下午1:48:11
 *email :hsqmobile@gmail.com
 */
public interface CaipiaoBaseDao<T extends Serializable>{

	public T getLatest();
	public ArrayList<T> getPage(Page page);
	public T getById(long nid);
}
