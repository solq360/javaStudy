package org.solq.lesson8.demo;

import java.util.HashMap;
import java.util.Map;

  
/**
 * 仓库
 * */
public class Repository {

	  public Map<Integer, Item> items = new HashMap<>();

	public static Repository of() {
		//剩余库存
		int initValue=500000;
		//最小库存
		int min = 5;
		int max = 500000;
		int add =2;
		Item[] items={
				Item.of(1,"物品1",initValue,min,max,add),
				Item.of(2,"物品2",initValue,min,max,add),
				Item.of(3,"物品3",initValue,min,max,add),
				Item.of(4,"物品4",initValue,min,max,add),
				Item.of(5,"物品5",initValue,min,max,add),
				Item.of(6,"物品6",initValue,min,max,add),
				Item.of(7,"物品7",initValue,min,max,add),
				Item.of(8,"物品8",initValue,min,max,add),
		};
		

		Map<Integer, Item> tmp = new HashMap<>(items.length);
		for(Item item : items){
			tmp.put(item.id, item);
		}
		Repository ret = new Repository();
		
		ret.items=tmp;
		return ret;
	}
}
