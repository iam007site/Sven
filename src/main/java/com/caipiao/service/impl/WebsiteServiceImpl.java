package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.WebsiteDao;
import com.caipiao.domain.Website;
import com.caipiao.domain.base.Page;
import com.caipiao.domain.item.WebsiteItem;
import com.caipiao.service.WebsiteService;

/*author:huangshanqi
 *time  :2015年3月8日 下午12:15:11
 *email :hsqmobile@gmail.com
 */
@Service
public class WebsiteServiceImpl implements WebsiteService {

	private final int Max_PageSize = 10;

	@Autowired
	private WebsiteDao websiteDao;

	@Transactional
	@Override
	public long create(Website entity) {
		// TODO Auto-generated method stub
		Website web = websiteDao.fingByUrl(entity.getUrl());
		if (web != null) {
			return -1;
		}
		return websiteDao.create(entity);
	}

	@Transactional
	@Override
	public Website findById(long nid) {
		// TODO Auto-generated method stub
		return websiteDao.findById(nid);
	}

	@Transactional
	@Override
	public boolean deleteById(long nid) {
		// TODO Auto-generated method stub
		return websiteDao.deleteById(nid) > 0;
	}

	@Transactional
	@Override
	public boolean update(Website entity) {
		// TODO Auto-generated method stub
		return websiteDao.update(entity) > 0;
	}

	@Transactional
	@Override
	public ArrayList<WebsiteItem> getPage(Page page) {
		// TODO Auto-generated method stub
		page.setPageSize(page.getPageSize() > Max_PageSize ? Max_PageSize : page.getPageSize());
		return websiteDao.getPage(page);
	}

	@Transactional
	@Override
	public ArrayList<WebsiteItem> getPageByOffset(Page page) {
		// TODO Auto-generated method stub
		page.setPageSize(page.getPageSize() > Max_PageSize ? Max_PageSize : page.getPageSize());
		return websiteDao.getPageByOffset(page);
	}

	@Transactional
	@Override
	public long getTotalNum() {
		// TODO Auto-generated method stub
		return websiteDao.getTotalNum();
	}

}
