package com.hsq.sven.form;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年3月28日 上午12:11:24
 *email :hsqmobile@gmail.com
 */
public class NewBlogForm implements Serializable{

	private String blogType;
	private String title;
	private String summary;
	private String content;
	private String category;
	private String tags;

	public String getBlogType() {
		return blogType;
	}

	public void setBlogType(String blogType) {
		this.blogType = blogType;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
