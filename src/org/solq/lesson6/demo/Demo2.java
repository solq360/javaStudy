package org.solq.lesson6.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {
		int count = 100000;
		int openCount = 500;
		List<Boolean> items = new ArrayList<>(count);
		
		int start =0;
		for(;start< openCount;start++){
			items.add(true);
		}
		//这时候START 是从500 
		for(;start< count;start++){
			items.add(false);
		}
		
		Collections.shuffle(items);
		
		for(boolean b : items){
			System.out.println(b);
		}
		
		int buyIndex = 0;
		
		boolean ok=items.get(buyIndex++);
		if(ok){
			System.out.println("恭喜你已抢到物品 ：" +"xxxx");
		}
	}

}
