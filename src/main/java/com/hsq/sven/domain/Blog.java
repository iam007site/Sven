package com.hsq.sven.domain;

import java.io.Serializable;

import com.hsq.sven.domain.base.BaseDomain;

/*author:huangshanqi
 *time  :2015年3月22日 下午1:33:12
 *email :hsqmobile@gmail.com
 */
public class Blog extends BaseDomain implements Serializable {

	private String title;
	private String author;
	private String content;
	private long CategoryId;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}

}
