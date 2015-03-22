package com.caipiao.domain;

import java.io.Serializable;

import com.caipiao.domain.base.CaiPiaoBaseDomain;

/*author:huangshanqi
 *time  :2015年3月7日 下午1:23:31
 *email :hsqmobile@gmail.com
 */
public class Fc3dDetail extends CaiPiaoBaseDomain implements Serializable {

	private int one;
	private int ten;
	private int hundred;
	private long sale;
	private long zhisanHitNumner;
	private long zhisanHitAward;
	private long zusanHitNumner;
	private long zusanHitAward;
	private long zuliuHitNumner;
	private long zuliuHitAward;

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getHundred() {
		return hundred;
	}

	public void setHundred(int hundred) {
		this.hundred = hundred;
	}

	public long getSale() {
		return sale;
	}

	public void setSale(long sale) {
		this.sale = sale;
	}

	public long getZhisanHitNumner() {
		return zhisanHitNumner;
	}

	public void setZhisanHitNumner(long zhisanHitNumner) {
		this.zhisanHitNumner = zhisanHitNumner;
	}

	public long getZhisanHitAward() {
		return zhisanHitAward;
	}

	public void setZhisanHitAward(long zhisanHitAward) {
		this.zhisanHitAward = zhisanHitAward;
	}

	public long getZusanHitNumner() {
		return zusanHitNumner;
	}

	public void setZusanHitNumner(long zusanHitNumner) {
		this.zusanHitNumner = zusanHitNumner;
	}

	public long getZusanHitAward() {
		return zusanHitAward;
	}

	public void setZusanHitAward(long zusanHitAward) {
		this.zusanHitAward = zusanHitAward;
	}

	public long getZuliuHitNumner() {
		return zuliuHitNumner;
	}

	public void setZuliuHitNumner(long zuliuHitNumner) {
		this.zuliuHitNumner = zuliuHitNumner;
	}

	public long getZuliuHitAward() {
		return zuliuHitAward;
	}

	public void setZuliuHitAward(long zuliuHitAward) {
		this.zuliuHitAward = zuliuHitAward;
	}

}
