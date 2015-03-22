package com.caipiao.domain;

import java.io.Serializable;

import com.caipiao.domain.base.CaiPiaoBaseDomain;

/*author:huangshanqi
 *time  :2015年3月7日 下午1:22:55
 *email :hsqmobile@gmail.com
 */
public class DltDetail extends CaiPiaoBaseDomain implements Serializable {

	private int redOne;
	private int redTwo;
	private int redThree;
	private int redFour;
	private int redFive;
	private int blueOne;
	private int blueTwo;

	private long sale;
	// 注意
	private String award;

	private long oneBaseHitNumber;
	private long oneBaseHitAward;
	private long oneAddHitNumber;
	private long oneAddHitAward;

	private long twoBaseHitNumber;
	private long twoBaseHitAward;
	private long twoAddHitNumber;
	private long twoAddHitAward;

	private long threeBaseHitNumber;
	private long threeBaseHitAward;
	private long threeAddHitNumber;
	private long othreeAddHitAward;

	private long fourBaseHitNumber;
	private long fourBaseHitAward;
	private long fourAddHitNumber;
	private long fourAddHitAward;

	private long fiveBaseHitNumber;
	private long fiveBaseHitAward;
	private long fiveAddHitNumber;
	private long fiveAddHitAward;

	private long sixBaseHitNumber;
	private long sixBaseHitAward;

	public int getRedOne() {
		return redOne;
	}

	public void setRedOne(int redOne) {
		this.redOne = redOne;
	}

	public int getRedTwo() {
		return redTwo;
	}

	public void setRedTwo(int redTwo) {
		this.redTwo = redTwo;
	}

	public int getRedThree() {
		return redThree;
	}

	public void setRedThree(int redThree) {
		this.redThree = redThree;
	}

	public int getRedFour() {
		return redFour;
	}

	public void setRedFour(int redFour) {
		this.redFour = redFour;
	}

	public int getRedFive() {
		return redFive;
	}

	public void setRedFive(int redFive) {
		this.redFive = redFive;
	}

	public int getBlueOne() {
		return blueOne;
	}

	public void setBlueOne(int blueOne) {
		this.blueOne = blueOne;
	}

	public int getBlueTwo() {
		return blueTwo;
	}

	public void setBlueTwo(int blueTwo) {
		this.blueTwo = blueTwo;
	}

	public long getSale() {
		return sale;
	}

	public void setSale(long sale) {
		this.sale = sale;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public long getOneBaseHitNumber() {
		return oneBaseHitNumber;
	}

	public void setOneBaseHitNumber(long oneBaseHitNumber) {
		this.oneBaseHitNumber = oneBaseHitNumber;
	}

	public long getOneBaseHitAward() {
		return oneBaseHitAward;
	}

	public void setOneBaseHitAward(long oneBaseHitAward) {
		this.oneBaseHitAward = oneBaseHitAward;
	}

	public long getOneAddHitNumber() {
		return oneAddHitNumber;
	}

	public void setOneAddHitNumber(long oneAddHitNumber) {
		this.oneAddHitNumber = oneAddHitNumber;
	}

	public long getOneAddHitAward() {
		return oneAddHitAward;
	}

	public void setOneAddHitAward(long oneAddHitAward) {
		this.oneAddHitAward = oneAddHitAward;
	}

	public long getTwoBaseHitNumber() {
		return twoBaseHitNumber;
	}

	public void setTwoBaseHitNumber(long twoBaseHitNumber) {
		this.twoBaseHitNumber = twoBaseHitNumber;
	}

	public long getTwoBaseHitAward() {
		return twoBaseHitAward;
	}

	public void setTwoBaseHitAward(long twoBaseHitAward) {
		this.twoBaseHitAward = twoBaseHitAward;
	}

	public long getTwoAddHitNumber() {
		return twoAddHitNumber;
	}

	public void setTwoAddHitNumber(long twoAddHitNumber) {
		this.twoAddHitNumber = twoAddHitNumber;
	}

	public long getTwoAddHitAward() {
		return twoAddHitAward;
	}

	public void setTwoAddHitAward(long twoAddHitAward) {
		this.twoAddHitAward = twoAddHitAward;
	}

	public long getThreeBaseHitNumber() {
		return threeBaseHitNumber;
	}

	public void setThreeBaseHitNumber(long threeBaseHitNumber) {
		this.threeBaseHitNumber = threeBaseHitNumber;
	}

	public long getThreeBaseHitAward() {
		return threeBaseHitAward;
	}

	public void setThreeBaseHitAward(long threeBaseHitAward) {
		this.threeBaseHitAward = threeBaseHitAward;
	}

	public long getThreeAddHitNumber() {
		return threeAddHitNumber;
	}

	public void setThreeAddHitNumber(long threeAddHitNumber) {
		this.threeAddHitNumber = threeAddHitNumber;
	}

	public long getOthreeAddHitAward() {
		return othreeAddHitAward;
	}

	public void setOthreeAddHitAward(long othreeAddHitAward) {
		this.othreeAddHitAward = othreeAddHitAward;
	}

	public long getFourBaseHitNumber() {
		return fourBaseHitNumber;
	}

	public void setFourBaseHitNumber(long fourBaseHitNumber) {
		this.fourBaseHitNumber = fourBaseHitNumber;
	}

	public long getFourBaseHitAward() {
		return fourBaseHitAward;
	}

	public void setFourBaseHitAward(long fourBaseHitAward) {
		this.fourBaseHitAward = fourBaseHitAward;
	}

	public long getFourAddHitNumber() {
		return fourAddHitNumber;
	}

	public void setFourAddHitNumber(long fourAddHitNumber) {
		this.fourAddHitNumber = fourAddHitNumber;
	}

	public long getFourAddHitAward() {
		return fourAddHitAward;
	}

	public void setFourAddHitAward(long fourAddHitAward) {
		this.fourAddHitAward = fourAddHitAward;
	}

	public long getFiveBaseHitNumber() {
		return fiveBaseHitNumber;
	}

	public void setFiveBaseHitNumber(long fiveBaseHitNumber) {
		this.fiveBaseHitNumber = fiveBaseHitNumber;
	}

	public long getFiveBaseHitAward() {
		return fiveBaseHitAward;
	}

	public void setFiveBaseHitAward(long fiveBaseHitAward) {
		this.fiveBaseHitAward = fiveBaseHitAward;
	}

	public long getFiveAddHitNumber() {
		return fiveAddHitNumber;
	}

	public void setFiveAddHitNumber(long fiveAddHitNumber) {
		this.fiveAddHitNumber = fiveAddHitNumber;
	}

	public long getFiveAddHitAward() {
		return fiveAddHitAward;
	}

	public void setFiveAddHitAward(long fiveAddHitAward) {
		this.fiveAddHitAward = fiveAddHitAward;
	}

	public long getSixBaseHitNumber() {
		return sixBaseHitNumber;
	}

	public void setSixBaseHitNumber(long sixBaseHitNumber) {
		this.sixBaseHitNumber = sixBaseHitNumber;
	}

	public long getSixBaseHitAward() {
		return sixBaseHitAward;
	}

	public void setSixBaseHitAward(long sixBaseHitAward) {
		this.sixBaseHitAward = sixBaseHitAward;
	}

}
