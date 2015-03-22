package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.AppFeedbackDao;
import com.caipiao.domain.AppFeedback;
import com.caipiao.domain.base.Page;
import com.caipiao.service.AppFeedbackService;

/*author:huangshanqi
 *time  :2015年3月12日 下午11:52:25
 *email :hsqmobile@gmail.com
 */
@Service
public class AppFeedbackServiceImpl implements AppFeedbackService {

	private final int Max_PageSize = 100;
	@Autowired
	private AppFeedbackDao appFeedbackDao;
	
	@Transactional
	@Override
	public long create(AppFeedback entity) {
		// TODO Auto-generated method stub
		return appFeedbackDao.create(entity);
	}

	@Transactional
	@Override
	public AppFeedback findById(long nid) {
		// TODO Auto-generated method stub
		return appFeedbackDao.findById(nid);
	}

	@Transactional
	@Override
	public boolean deleteById(long nid) {
		// TODO Auto-generated method stub
		return appFeedbackDao.deleteById(nid)>0;
	}

	@Transactional
	@Override
	public boolean update(AppFeedback entity) {
		// TODO Auto-generated method stub
		return appFeedbackDao.update(entity)>0;
	}

	@Transactional
	@Override
	public ArrayList<AppFeedback> getPage(Page page) {
		// TODO Auto-generated method stub
		page.setPageSize(page.getPageSize()>Max_PageSize?Max_PageSize:page.getPageSize());
		return appFeedbackDao.getPage(page);
	}

	@Transactional
	@Override
	public long getTotalNum() {
		// TODO Auto-generated method stub
		return appFeedbackDao.getTotalNum();
	}

	
	
	
}
