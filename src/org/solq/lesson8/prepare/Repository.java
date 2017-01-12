package org.solq.lesson8.prepare;

import java.util.HashMap;
import java.util.Map;

 
public class Repository {

	Map<Integer, Item> datas ;

	public static Repository of() {
		int count = 5000;
		int initValue = count;
		Item[] items={
				Item.of(1,"物品1",initValue,1,count,2),
				Item.of(2,"物品2",initValue,3,count,2),
				Item.of(3,"物品3",initValue,3,count,2),
				Item.of(4,"物品4",initValue,3,count,2),
				Item.of(5,"物品5",initValue,3,count,2),
				Item.of(6,"物品7",initValue,3,count,2),
				Item.of(7,"物品8",initValue,3,count,2),
				Item.of(8,"物品9",initValue,3,count,2),
		};
		Map<Integer, Item> datas =new HashMap<>(items.length);
		for(Item item : items){
			datas.put(item.id, item);
		}
		Repository ret = new Repository();
		ret.datas=datas;
		return ret;
	}
}
