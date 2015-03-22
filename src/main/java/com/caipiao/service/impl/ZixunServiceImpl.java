package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.ZixunDao;
import com.caipiao.domain.ZixunDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.domain.item.ZixunItem;
import com.caipiao.service.ZixunService;

/*author:huangshanqi
 *time  :2015年3月7日 下午3:13:15
 *email :hsqmobile@gmail.com
 */
@Service
public class ZixunServiceImpl implements ZixunService {

	@Autowired
	private ZixunDao zixunDao;

	@Transactional
	@Override
	public ZixunDetail getZixunDetail(long zxId) {
		// TODO Auto-generated method stub
		return zixunDao.getById(zxId);
	}

	@Transactional
	@Override
	public ArrayList<ZixunItem> getZixunPageByType(Page page) {
		// TODO Auto-generated method stub
		return zixunDao.getZixunPageByType(page);
	}

	@Transactional
	@Override
	public ArrayList<ZixunItem> getPageByOffset(Page page) {
		// TODO Auto-generated method stub
		return zixunDao.getPageByOffset(page);
	}

	@Transactional
	@Override
	public long create(ZixunDetail zixun) {
		// TODO Auto-generated method stub
		return zixunDao.create(zixun);
	}

	@Transactional
	@Override
	public long getTotalNum() {
		// TODO Auto-generated method stub
		return zixunDao.getTotalNum();
	}

	@Transactional
	@Override
	public boolean deleteById(long nid) {
		// TODO Auto-generated method stub
		return zixunDao.deleteById(nid)>0;
	}

	@Transactional
	@Override
	public boolean update(ZixunDetail zixun) {
		// TODO Auto-generated method stub
		return zixunDao.update(zixun)>0;
	}

	
}
