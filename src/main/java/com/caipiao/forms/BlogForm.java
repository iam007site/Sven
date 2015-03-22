package com.caipiao.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/*author:huangshanqi
 *time  :2015年2月7日 下午9:39:49
 *email :hsqmobile@gmail.com
 */
public class BlogForm {
	
	@NotNull(message = "标题不能为空")
	@Size(min=1,max=50,message="标题长度只能在1到50字符")
	private String title;
	
	@NotNull(message = "短博文不能为空")
	@Size(min=1,max=50,message="博文长度只能在1到500字符")
	private String content;
	
	@NotNull(message = "段博文必须属于一个分类")
	private int categoryId;
	
	//tagId：tagId组成的字符串
	private String tagIdList;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTagIdList() {
		return tagIdList;
	}
	public void setTagIdList(String tagIdList) {
		this.tagIdList = tagIdList;
	}
	

}
