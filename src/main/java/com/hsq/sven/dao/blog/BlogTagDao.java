package com.hsq.sven.dao.blog;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hsq.sven.dao.base.BaseDao;
import com.hsq.sven.domain.blog.BlogTag;

/*author:huangshanqi
 *time  :2015年3月23日 下午8:19:25
 *email :hsqmobile@gmail.com
 */
public interface BlogTagDao extends BaseDao<BlogTag> {
	
	public ArrayList<BlogTag> getUserAllTag(@Param("userId") long userId);
	
	public ArrayList<BlogTag> getBlogTag(@Param("blogId")long blogId);
}
