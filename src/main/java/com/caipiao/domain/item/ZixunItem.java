package com.caipiao.domain.item;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月7日 下午2:48:39
 *email :hsqmobile@gmail.com
 */
public class ZixunItem implements Serializable {

	private long nid;
	private String title;
	private String summary;
	private String author;
	private Date publishTime;
	private String caipiaoType;

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getCaipiaoType() {
		return caipiaoType;
	}

	public void setCaipiaoType(String caipiaoType) {
		this.caipiaoType = caipiaoType;
	}

}
