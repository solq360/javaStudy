package org.solq.lesson4.deom2;
/**
 * ����
 * */
public class Condition {
	/**
	 * Ŀ����Ʒ
	 * */
	String targetItem;
	/**
	 * ��������
	 * */
 	int gift;
 	/**
	 * ���㷵����������
	 * */
	int limit;
	
	/**
	 * �ж��Ƿ�����
	 * @return true �������㷵������ false ����ʧ��
	 * */
	public boolean checkOut(User user,String item) {
 
		
 		return false;
	}

	public static Condition of(int gift, int limit, String targetItem) {
		Condition ret =new Condition();
		ret.gift=gift;
		ret.limit=limit;
		ret.targetItem=targetItem;
		return ret;
	}
}
