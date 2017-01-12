package org.solq.lesson8.prepare;

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
	 * ���
	 */
	int num;
	/**
	 * ��С���
	 */
	int min;
	/**
	 * �����
	 */
	int max;
	
	/**
	 * ÿ�ν���
	 */
	int add;

	public static Item of(int id, String name, int num, int min, int max, int add) {
		Item ret = new Item();
		ret.id=id;
		ret.name = name;
		ret.num = num;
		ret.min = min;
		ret.max = max;
		ret.add =add;
		return ret;
	}

	public void buy() {
		this.num--;
	}
}
