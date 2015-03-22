package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.WebsiteCommentDao;
import com.caipiao.domain.WebsiteComment;
import com.caipiao.domain.base.Page;
import com.caipiao.service.WebsiteCommentService;

/*author:huangshanqi
 *time  :2015年3月8日 下午1:34:07
 *email :hsqmobile@gmail.com
 */
@Service
public class WebsiteCommentServiceImpl implements WebsiteCommentService {

	private final int Max_PageSize = 100;
	@Autowired
	private WebsiteCommentDao websiteCommentDao;
	
	@Transactional
	@Override
	public long create(WebsiteComment entity) {
		// TODO Auto-generated method stub
		return websiteCommentDao.create(entity);
	}

	@Transactional
	@Override
	public WebsiteComment findById(long nid) {
		// TODO Auto-generated method stub
		return websiteCommentDao.findById(nid);
	}

	@Transactional
	@Override
	public int deleteById(long nid) {
		// TODO Auto-generated method stub
		return websiteCommentDao.deleteById(nid);
	}

	@Transactional
	@Override
	public int update(WebsiteComment entity) {
		// TODO Auto-generated method stub
		return websiteCommentDao.update(entity);
	}

	@Transactional
	@Override
	public ArrayList<WebsiteComment> getPage(Page page) {
		// TODO Auto-generated method stub
		page.setPageSize(page.getPageSize()>Max_PageSize?Max_PageSize:page.getPageSize());
		return websiteCommentDao.getPage(page);
	}

	@Override
	public ArrayList<WebsiteComment> getAll(long websiteId) {
		// TODO Auto-generated method stub
		return websiteCommentDao.getAll(websiteId);
	}

	
}
