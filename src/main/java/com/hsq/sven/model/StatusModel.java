package com.hsq.sven.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年2月1日 下午6:30:21
 *email :hsqmobile@gmail.com
 */
public class StatusModel implements Serializable {

	private String status;

	public StatusModel(String status) {
		this.status = status;
	}

	public StatusModel() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
