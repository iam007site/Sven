package com.hsq.sven.service.blog;

import java.util.ArrayList;

import com.hsq.sven.domain.blog.BlogCategoryStatistic;
import com.hsq.sven.domain.blog.item.BlogItem;
import com.hsq.sven.form.NewBlogForm;

/*author:huangshanqi
 *time  :2015年3月28日 上午9:37:57
 *email :hsqmobile@gmail.com
 */
public interface BlogService {

	public boolean newBlog(NewBlogForm blogForm);
	public int getUserTotalBlogNum(long userId);
	
	public ArrayList<BlogItem> getUserBlogByOffset(long userId,int offset,int pageSize);
	public ArrayList<BlogCategoryStatistic> getUserBlogCategoryStatistic(long userId);
}
