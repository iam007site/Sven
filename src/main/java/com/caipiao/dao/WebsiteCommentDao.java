package com.caipiao.dao;

import java.util.ArrayList;

import com.caipiao.dao.base.BaseDao;
import com.caipiao.domain.WebsiteComment;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月8日 上午12:16:08
 *email :hsqmobile@gmail.com
 */
public interface WebsiteCommentDao extends BaseDao<WebsiteComment> {

	public ArrayList<WebsiteComment> getPage(Page page);
	public ArrayList<WebsiteComment> getAll(long websiteId);
}
