package com.hsq.sven.dao.blog;

import java.util.ArrayList;

import com.hsq.sven.dao.base.BaseDao;
import com.hsq.sven.domain.base.Page;
import com.hsq.sven.domain.blog.Blog;

/*author:huangshanqi
 *time  :2015年3月23日 下午8:19:25
 *email :hsqmobile@gmail.com
 */
public interface BlogDao extends BaseDao<Blog> {
	
	//offset,pageSize,userId
	public ArrayList<Blog> getByPage(Page page);
	//offset,pageSize,userId,categoryId
	public ArrayList<Blog> getByCategoryByPage(Page page);
}
