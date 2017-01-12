package org.solq.lesson8.prepare;

import java.util.HashMap;
import java.util.Map;

 
public class Repository {

	Map<Integer, Item> datas ;

	public static Repository of() {
		int count = 5000;
		int initValue = count;
		Item[] items={
				Item.of(1,"��Ʒ1",initValue,1,count,2),
				Item.of(2,"��Ʒ2",initValue,3,count,2),
				Item.of(3,"��Ʒ3",initValue,3,count,2),
				Item.of(4,"��Ʒ4",initValue,3,count,2),
				Item.of(5,"��Ʒ5",initValue,3,count,2),
				Item.of(6,"��Ʒ7",initValue,3,count,2),
				Item.of(7,"��Ʒ8",initValue,3,count,2),
				Item.of(8,"��Ʒ9",initValue,3,count,2),
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
