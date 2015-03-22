package com.caipiao.domain;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月12日 下午11:30:43
 *email :hsqmobile@gmail.com
 */
public class AppFeedback implements Serializable {

	private long nid;
	private Date publishTime;
	private String device;
	private String content;

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
