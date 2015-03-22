package com.caipiao.domain;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月7日 下午11:44:43
 *email :hsqmobile@gmail.com
 */
public class Advertising implements Serializable {

	private long nid;
	private String url;
	private String title;
	private String picture;
	private Date createTime;

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
