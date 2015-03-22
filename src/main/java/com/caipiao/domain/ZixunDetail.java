package com.caipiao.domain;

import java.io.Serializable;

import com.caipiao.domain.item.ZixunItem;

/*author:huangshanqi
 *time  :2015年3月7日 下午1:25:27
 *email :hsqmobile@gmail.com
 */
public class ZixunDetail extends ZixunItem implements Serializable {

	private String content;
	private String url;
	private String author;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
