package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.WebsiteComment;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月8日 下午1:32:37
 *email :hsqmobile@gmail.com
 */
public interface WebsiteCommentService {

	public long create(WebsiteComment entity);
	public WebsiteComment findById(long nid);
	public int deleteById(long nid);
	public int update(WebsiteComment entity);
	public ArrayList<WebsiteComment> getPage(Page page);
	public ArrayList<WebsiteComment> getAll(long websiteId);
}
