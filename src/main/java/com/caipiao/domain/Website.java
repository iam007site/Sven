package com.caipiao.domain;

import java.io.Serializable;
import java.util.Date;

import com.caipiao.domain.item.WebsiteItem;

/*author:huangshanqi
 *time  :2015年3月7日 下午11:50:04
 *email :hsqmobile@gmail.com
 */
public class Website extends WebsiteItem implements Serializable {

	private String pictures;
	private String summary;
	private String content;
	private int vp;

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getVp() {
		return vp;
	}

	public void setVp(int vp) {
		this.vp = vp;
	}

}
