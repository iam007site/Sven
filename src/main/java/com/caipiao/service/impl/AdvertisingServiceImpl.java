package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.AdvertisingDao;
import com.caipiao.domain.Advertising;
import com.caipiao.domain.base.Page;
import com.caipiao.service.AdvertisingService;

/*author:huangshanqi
 *time  :2015年3月8日 上午10:57:39
 *email :hsqmobile@gmail.com
 */
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

	private final int Max_PageSize = 10;
	@Autowired
	private AdvertisingDao advertisingDao;

	@Transactional
	@Override
	public long create(Advertising entity) {
		// TODO Auto-generated method stub
		Advertising ad = advertisingDao.fingByUrl(entity.getUrl());
		if (ad != null) {
			return -1;
		}

		return advertisingDao.create(entity);
	}

	@Transactional
	@Override
	public Advertising findById(long nid) {
		// TODO Auto-generated method stub
		return advertisingDao.findById(nid);
	}

	@Transactional
	@Override
	public boolean deleteById(long nid) {
		// TODO Auto-generated method stub
		return advertisingDao.deleteById(nid) > 0;
	}

	@Transactional
	@Override
	public boolean update(Advertising entity) {
		// TODO Auto-generated method stub
		return advertisingDao.update(entity) > 0;
	}

	@Transactional
	@Override
	public ArrayList<Advertising> getPage(Page page) {
		// TODO Auto-generated method stub
		page.setPageSize(page.getPageSize() > Max_PageSize ? Max_PageSize : page.getPageSize());

		return advertisingDao.getPage(page);
	}

	@Transactional
	@Override
	public ArrayList<Advertising> getPageByOffset(Page page) {
		// TODO Auto-generated method stub
		page.setPageSize(page.getPageSize() > Max_PageSize ? Max_PageSize : page.getPageSize());

		return advertisingDao.getPageByOffset(page);
	}

	@Transactional
	@Override
	public long getTotalNum() {
		// TODO Auto-generated method stub
		return advertisingDao.getTotalNum();
	}

}
