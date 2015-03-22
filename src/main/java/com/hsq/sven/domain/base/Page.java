package com.hsq.sven.domain.base;

import java.io.Serializable;
import java.util.Map;

/*author:huangshanqi
 *time  :2015年2月6日 上午12:40:07
 *email :hsqmobile@gmail.com
 */
public class Page implements Serializable {

	private int offset;
	private int pageSize;
	private Map<String, Object> condition;// 查询条件

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

}
