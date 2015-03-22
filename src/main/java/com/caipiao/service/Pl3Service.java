package com.caipiao.service;

import java.util.ArrayList;

import com.caipiao.domain.Pl3Detail;
import com.caipiao.domain.base.Page;

/*author:huangshanqi
 *time  :2015年3月7日 下午3:11:07
 *email :hsqmobile@gmail.com
 */
public interface Pl3Service {

	public Pl3Detail getLatest();
	public ArrayList<Pl3Detail> getPage(Page page);
	public Pl3Detail getById(long nid);
}
