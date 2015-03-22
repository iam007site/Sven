package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.AppFeedback;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月8日 上午10:55:29
 *email :hsqmobile@gmail.com
 */
public interface AppFeedbackService {

	public long create(AppFeedback entity);
	public AppFeedback findById(long nid);
	public boolean deleteById(long nid);
	public boolean update(AppFeedback entity);
	public ArrayList<AppFeedback> getPage(Page page);
	public long getTotalNum();
}
