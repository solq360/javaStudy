package org.solq.lesson7.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo {

	public static void main(String[] args) {
		Item item1 = Item.of(1,"物品1",5,1);
		Item item2 = Item.of(2,"物品2",6,2);
		Item item3 = Item.of(3,"物品3",7,3);
		Item item4 = Item.of(4,"物品4",8,8);
		
		
		Map<Integer, Item> items = buildItemsData(item1,item2,item3,item4);
		for(Entry<Integer, Item> entry : items.entrySet()){
			System.out.println("id : " + entry.getKey() + " name :" + entry.getValue().name);
		}
 	}

	private static Map<Integer, Item> buildItemsData(Item... items) {
		Map<Integer, Item> ret = new HashMap<>();
		for(Item item : items){
			ret.put(item.id, item);
		}
		return ret;
	}

}
