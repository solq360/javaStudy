package org.solq.lesson8.prepare;

public class Item {
	/**
	 * 物品编号
	 */
	int id;
	/**
	 * 物品名称
	 */
	String name;
	/**
	 * 库存
	 */
	int num;
	/**
	 * 最小库存
	 */
	int min;
	/**
	 * 最大库存
	 */
	int max;
	
	/**
	 * 每次进货
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
