package org.solq.lesson11;

public interface Service {
	/**
	 * �û�ʵ��ע��
	 * @author solq
	 * @param name �û���
	 * @param phone �ֻ�����
	 * @param identity ��ݷ�
	 * @return ����״̬
	 * */
	 int registerName(String name,int phone,String identity);
	/**
	 * �û�ʵ��ע��
	 * @author solq
	 * @param phone �ֻ�����
	 * @param  money ��ֵ���
	 * @return ��ֵ״̬
	 * */
	int charge(int phone,int money);
	/**
	 * vipר��
	 * @author solq
	 * @param phone �ֻ�����
	 * */
	int vipChannel(int phone);
	
	int buyFlow(int phone ,int money);
	
	int store(int phone);
}
