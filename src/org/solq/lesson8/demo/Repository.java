package org.solq.lesson8.demo;

import java.util.HashMap;
import java.util.Map;

  
/**
 * �ֿ�
 * */
public class Repository {

	  public Map<Integer, Item> items = new HashMap<>();

	public static Repository of() {
		//ʣ����
		int initValue=500000;
		//��С���
		int min = 5;
		int max = 500000;
		int add =2;
		Item[] items={
				Item.of(1,"��Ʒ1",initValue,min,max,add),
				Item.of(2,"��Ʒ2",initValue,min,max,add),
				Item.of(3,"��Ʒ3",initValue,min,max,add),
				Item.of(4,"��Ʒ4",initValue,min,max,add),
				Item.of(5,"��Ʒ5",initValue,min,max,add),
				Item.of(6,"��Ʒ6",initValue,min,max,add),
				Item.of(7,"��Ʒ7",initValue,min,max,add),
				Item.of(8,"��Ʒ8",initValue,min,max,add),
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
