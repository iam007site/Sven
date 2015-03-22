package com.hsq.sven.domain;

import java.io.Serializable;

import com.hsq.sven.domain.base.BaseDomain;

/*author:huangshanqi
 *time  :2015年3月22日 下午1:36:55
 *email :hsqmobile@gmail.com
 */
public class BlogTag extends BaseDomain implements Serializable {

	private long blogId;
	private long tagId;

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

}
