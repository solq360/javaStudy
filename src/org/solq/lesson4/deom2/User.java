package org.solq.lesson4.deom2;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 * */
public class User {
	HashMap<String, Record> recordMap = new HashMap<>();
	
	void buy(String item, int count){
		Record record=recordMap.get(item);
		record.buyCount+=count;
	}

	/**
	 * 增加系统返还记录
	 * */
	public void addGift(String item,int gift) {
		Record record=recordMap.get(item);
		record.gift+=gift;
		
	}
}
