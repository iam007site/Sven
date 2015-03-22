package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.Fc3dDao;
import com.caipiao.domain.Fc3dDetail;
import com.caipiao.domain.base.Page;
import com.caipiao.service.Fc3dService;

/*author:huangshanqi
 *time  :2015年3月7日 下午9:39:46
 *email :hsqmobile@gmail.com
 */
@Service
public class Pl3ServiceImpl implements Fc3dService{

	@Autowired
	private Fc3dDao fc3dDao;
	
	@Transactional
	@Override
	public Fc3dDetail getLatest() {
		// TODO Auto-generated method stub
		return fc3dDao.getLatest();
	}

	@Transactional
	@Override
	public ArrayList<Fc3dDetail> getPage(Page page) {
		// TODO Auto-generated method stub
		return fc3dDao.getPage(page);
	}

	@Transactional
	@Override
	public Fc3dDetail getById(long nid) {
		// TODO Auto-generated method stub
		return fc3dDao.getById(nid);
	}

}
