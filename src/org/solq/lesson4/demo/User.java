package org.solq.lesson4.demo;

/**用户对象*/
public class User {

	/**消费记录*/
	double recordValue = 0d;
	/**系统总赠送多少钱*/
	double gift = 0d;
	/**
	 * 购买物品
	 * */
	void buy(double buyValue){
		recordValue=recordValue+buyValue;
	}
	/**
	 * 系统返还数量
	 * */
	public void addGift(double giftValue) {
		gift+= giftValue;
	}
}
