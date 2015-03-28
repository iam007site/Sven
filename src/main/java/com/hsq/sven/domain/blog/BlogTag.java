package com.hsq.sven.domain.blog;

import java.io.Serializable;

import com.hsq.sven.domain.base.BaseDomain;

/*author:huangshanqi
 *time  :2015年3月22日 下午1:36:55
 *email :hsqmobile@gmail.com
 */
public class BlogTag extends BaseDomain implements Serializable {

	private long blogId;
	private long userId;
	private String tagName;

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
