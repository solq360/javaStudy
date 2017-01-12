package org.solq.lesson11;

public interface Service {
	/**
	 * 用户实名注册
	 * @author solq
	 * @param name 用户名
	 * @param phone 手机号码
	 * @param identity 身份份
	 * @return 申请状态
	 * */
	 int registerName(String name,int phone,String identity);
	/**
	 * 用户实名注册
	 * @author solq
	 * @param phone 手机号码
	 * @param  money 充值金额
	 * @return 充值状态
	 * */
	int charge(int phone,int money);
	/**
	 * vip专享
	 * @author solq
	 * @param phone 手机号码
	 * */
	int vipChannel(int phone);
	
	int buyFlow(int phone ,int money);
	
	int store(int phone);
}
