package com.hsq.sven.domain.blog.item;

import java.util.ArrayList;

import com.hsq.sven.domain.base.BaseDomain;

/*author:huangshanqi
 *time  :2015年3月28日 下午11:30:38
 *email :hsqmobile@gmail.com
 */
public class BlogItem extends BaseDomain {
	private String blogType;
	private String title;
	private String author;
	private String summary;
	private String categoryName;
	private long categoryId;
	private ArrayList<String> tags;

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

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

}
