package com.hsq.sven.dao.base;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

/*author:huangshanqi
 *time  :2015年2月1日 下午8:53:59
 *email :hsqmobile@gmail.com
 */
public interface BaseDao <T extends Serializable>{
	
	public long create(T entity);
	public T findById(@Param("id")long nid);
	public int deleteById(@Param("id")long nid);
	public int update(T entity);

}
