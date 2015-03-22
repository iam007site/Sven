package com.caipiao.domain;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月7日 下午11:55:52
 *email :hsqmobile@gmail.com
 */
public class WebsiteComment implements Serializable {

	private long nid;
	private long websiteId;
	private String content;
	private String username;
	private Date createTime;
	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public long getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(long websiteId) {
		this.websiteId = websiteId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
