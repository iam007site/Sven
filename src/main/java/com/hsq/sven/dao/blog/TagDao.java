package com.hsq.sven.dao.blog;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hsq.sven.dao.base.BaseDao;
import com.hsq.sven.domain.base.Page;
import com.hsq.sven.domain.blog.Blog;
import com.hsq.sven.domain.blog.BlogTag;
import com.hsq.sven.domain.blog.Tag;

/*author:huangshanqi
 *time  :2015年3月23日 下午8:19:25
 *email :hsqmobile@gmail.com
 */
public interface TagDao extends BaseDao<Tag> {
	
	//condition.userId,condition.name
	public Tag getByUserIdName(Page page);
	public ArrayList<Tag> getUserAllTag(@Param("userId") long userId);
	
	
	
	
	//BlogTag
	public long createBlogTag(BlogTag entity);
	public ArrayList<BlogTag> getBlogTag(@Param("blogId")long blogId);
	//offset,pageSize,condition.tagId,condition.userId
	public ArrayList<Blog> getBlogByTagByPage(Page page);
}
