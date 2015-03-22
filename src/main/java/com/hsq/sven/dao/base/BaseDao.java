package com.hsq.sven.dao.base;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:53:59
 *email :hsqmobile@gmail.com
 */
public interface BaseDao <T extends Serializable>{
	
	public int create(T entity);
	public T findById(long nid);
	public int deleteById(long nid);
	public int update(T entity);

}
