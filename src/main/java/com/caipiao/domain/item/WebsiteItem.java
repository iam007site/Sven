package com.caipiao.domain.item;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月8日 上午11:49:05
 *email :hsqmobile@gmail.com
 */
public class WebsiteItem implements Serializable {

	private long nid;
	private String url;
	private String name;
	private int score;
	private String logo;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
