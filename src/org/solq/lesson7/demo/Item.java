package org.solq.lesson7.demo;

/**
 * ��Ʒ
 */
public class Item {
	/**
	 * ��Ʒ���
	 */
	int id;
	/**
	 * ��Ʒ����
	 */
	String name;
	/**
	 * ��������
	 */
	int buyLimit;
	/**
	 * ��������
	 */
	int gift;

	public static Item of(int id, String name, int buyLimit, int gift) {
		Item ret = new Item();
		ret.id = id;
		ret.name = name;
		ret.buyLimit = buyLimit;
		ret.gift = gift;
		return ret;
	}
}
