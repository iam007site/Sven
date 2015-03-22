package com.hsq.sven.domain;

import java.io.Serializable;
import java.util.Date;

import com.hsq.sven.domain.base.BaseDomain;

/*author:huangshanqi
 *time  :2015年3月22日 下午1:37:38
 *email :hsqmobile@gmail.com
 */
public class Task extends BaseDomain implements Serializable {

	private Date startTime;
	private Date endTime;
	private String content;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
