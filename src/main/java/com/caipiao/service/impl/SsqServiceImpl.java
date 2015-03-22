package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.SsqDao;
import com.caipiao.domain.SsqDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.service.SsqService;

/*author:huangshanqi
 *time  :2015年3月7日 下午9:39:46
 *email :hsqmobile@gmail.com
 */
@Service
public class SsqServiceImpl implements SsqService{

	@Autowired
	private SsqDao ssqDao;
	
	@Transactional
	@Override
	public SsqDetail getLatest() {
		// TODO Auto-generated method stub
		return ssqDao.getLatest();
	}

	@Transactional
	@Override
	public ArrayList<SsqDetail> getPage(Page page) {
		// TODO Auto-generated method stub
		return ssqDao.getPage(page);
	}

	@Transactional
	@Override
	public SsqDetail getById(long nid) {
		// TODO Auto-generated method stub
		return ssqDao.getById(nid);
	}

}
