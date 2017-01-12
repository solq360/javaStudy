package org.solq.lesson4.deom2;
/**
 * 条件
 * */
public class Condition {
	/**
	 * 目标物品
	 * */
	String targetItem;
	/**
	 * 返还数量
	 * */
 	int gift;
 	/**
	 * 满足返还次数条件
	 * */
	int limit;
	
	/**
	 * 判断是否满足
	 * @return true 代表满足返还条件 false 代表失败
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
