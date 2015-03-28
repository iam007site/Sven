package com.hsq.sven.domain.blog;

/*author:huangshanqi
 *time  :2015年3月28日 下午10:07:52
 *email :hsqmobile@gmail.com
 */
public class BlogCategoryStatistic {

	private String author;
	private long categoryId;
	private String categoryName;
	private int num;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
