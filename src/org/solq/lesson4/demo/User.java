package org.solq.lesson4.demo;

/**�û�����*/
public class User {

	/**���Ѽ�¼*/
	double recordValue = 0d;
	/**ϵͳ�����Ͷ���Ǯ*/
	double gift = 0d;
	/**
	 * ������Ʒ
	 * */
	void buy(double buyValue){
		recordValue=recordValue+buyValue;
	}
	/**
	 * ϵͳ��������
	 * */
	public void addGift(double giftValue) {
		gift+= giftValue;
	}
}
