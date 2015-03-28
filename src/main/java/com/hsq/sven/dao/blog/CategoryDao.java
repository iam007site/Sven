package com.hsq.sven.dao.blog;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.hsq.sven.dao.base.BaseDao;
import com.hsq.sven.domain.base.Page;
import com.hsq.sven.domain.blog.Category;

/*author:huangshanqi
 *time  :2015年3月23日 下午8:19:25
 *email :hsqmobile@gmail.com
 */
public interface CategoryDao extends BaseDao<Category> {
	
	//condition.userId,condition.name
	public Category getByUserIdName1(Page page);
	public Category getByUserIdName(@Param("userId") long userId,@Param("name") String name);
	public ArrayList<Category> getUserAllCategory(@Param("userId") long userId);
}
