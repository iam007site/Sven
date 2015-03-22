package com.caipiao.dao;

import java.util.ArrayList;

import com.caipiao.dao.base.BaseDao;
import com.caipiao.domain.AppFeedback;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月8日 上午12:15:43
 *email :hsqmobile@gmail.com
 */
public interface AppFeedbackDao extends BaseDao<AppFeedback> {
	public ArrayList<AppFeedback> getPage(Page page);
	public long getTotalNum();
}
