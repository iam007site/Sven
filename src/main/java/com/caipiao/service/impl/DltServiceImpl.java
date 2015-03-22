package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.DltDao;
import com.caipiao.domain.DltDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.service.DltService;

/*author:huangshanqi
 *time  :2015年3月7日 下午9:39:46
 *email :hsqmobile@gmail.com
 */
@Service
public class DltServiceImpl implements DltService{

	@Autowired
	private DltDao dltDao;
	
	@Transactional
	@Override
	public DltDetail getLatest() {
		// TODO Auto-generated method stub
		return dltDao.getLatest();
	}

	@Transactional
	@Override
	public ArrayList<DltDetail> getPage(Page page) {
		// TODO Auto-generated method stub
		return dltDao.getPage(page);
	}

	@Transactional
	@Override
	public DltDetail getById(long nid) {
		// TODO Auto-generated method stub
		return dltDao.getById(nid);
	}

}
