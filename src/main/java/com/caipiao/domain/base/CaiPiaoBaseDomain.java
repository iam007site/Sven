package com.caipiao.domain.base;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年3月7日 下午1:20:15
 *email :hsqmobile@gmail.com
 */
public class CaiPiaoBaseDomain implements Serializable {

	private long nid;
	private long term;
	private Date openTime;

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public long getTerm() {
		return term;
	}

	public void setTerm(long term) {
		this.term = term;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

}
