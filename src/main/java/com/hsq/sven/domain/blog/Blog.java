package com.hsq.sven.domain.blog;

import java.io.Serializable;

import com.hsq.sven.domain.base.BaseDomain;

/*author:huangshanqi
 *time  :2015年3月22日 下午1:33:12
 *email :hsqmobile@gmail.com
 */
public class Blog extends BaseDomain implements Serializable {

	private long userId;
	private String blogType;
	private String title;
	private String author;
	private String summary;
	private String content;
	private String categoryName;
	private long categoryId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

}
