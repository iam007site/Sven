package com.caipiao.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caipiao.dao.Pl3Dao;
import com.caipiao.domain.Pl3Detail;
import com.caipiao.domain.base.Page;
import com.caipiao.service.Pl3Service;

/*author:huangshanqi
 *time  :2015年3月7日 下午9:39:46
 *email :hsqmobile@gmail.com
 */
@Service
public class Fc3dServiceImpl implements Pl3Service{

	@Autowired
	private Pl3Dao pl3Dao;
	
	@Transactional
	@Override
	public Pl3Detail getLatest() {
		// TODO Auto-generated method stub
		return pl3Dao.getLatest();
	}

	@Transactional
	@Override
	public ArrayList<Pl3Detail> getPage(Page page) {
		// TODO Auto-generated method stub
		return pl3Dao.getPage(page);
	}

	@Transactional
	@Override
	public Pl3Detail getById(long nid) {
		// TODO Auto-generated method stub
		return pl3Dao.getById(nid);
	}

}
