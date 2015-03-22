package com.hsq.sven.domain.base;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月22日 下午1:31:28
 *email :hsqmobile@gmail.com
 */
public class BaseDomain implements Serializable {

	private long id;
	private Date createTime;
	private Date updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
