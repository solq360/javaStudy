package org.solq.lesson7.demo;

/**
 * 物品
 */
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
	 * 返还条件
	 */
	int buyLimit;
	/**
	 * 返还数量
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
