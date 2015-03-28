package com.hsq.sven.dao.blog;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hsq.sven.dao.base.BaseDao;
import com.hsq.sven.domain.base.Page;
import com.hsq.sven.domain.blog.Blog;
import com.hsq.sven.domain.blog.BlogCategoryStatistic;
import com.hsq.sven.domain.blog.item.BlogItem;

/*author:huangshanqi
 *time  :2015年3月23日 下午8:19:25
 *email :hsqmobile@gmail.com
 */
public interface BlogDao extends BaseDao<Blog> {
	
	//offset,pageSize,userId
	public ArrayList<Blog> getByPage(Page page);
	//offset,pageSize,userId,categoryId
	public ArrayList<Blog> getByCategoryByPage(Page page);
	
	public int getUserTotalBlogNum(@Param("userId")long userId);
	public ArrayList<BlogItem> getUserBlogByOffset(@Param("userId") long userId,@Param("offset") int offset,@Param("pageSize") int pageSize);
    public ArrayList<BlogCategoryStatistic> getUsrBlogCategoryStatistic(@Param("userId") long userId);
}
