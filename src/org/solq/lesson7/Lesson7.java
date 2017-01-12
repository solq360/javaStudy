package org.solq.lesson7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Lesson7 {

	//ctrl + f11
	public static void main(String[] args) {
		//map<图书编号，图书>
		Map<Integer, String> books = new HashMap<>();
		books.put(1, "java从入门到卖肠粉系列");
		books.put(2, "如何治疗颈椎病");
		books.put(3, "穷爸爸富爸爸");
		books.put(4, "不要让不好意思害了你");
		
		
		String bookName = books.get(1);
		System.out.println(bookName);
		
 		System.out.println("size:"+books.size());
 		System.out.println("isEmpty:"+books.isEmpty());
 		System.out.println("containsKey:"+books.containsKey(11));
 		System.out.println("containsValue:"+books.containsValue("穷爸爸富爸爸"));
 		System.out.println("keySet size :"+books.keySet().size());
 		Set<Integer> keys= books.keySet();
 		for(int key : keys){
 	 		System.out.println("key :"+key);
 		}
 		
 		Collection<String> values= books.values();
 		for(String value : values){
 	 		System.out.println("value :"+value);
 		}
 		
 		Collection<Entry<Integer, String>> entrys= books.entrySet();
 		for(Entry<Integer, String> entry : entrys){
 	 		System.out.println("key :"+entry.getKey() + " value :"+entry.getValue());
 		}
 		
 		//jdk 1.8
		bookName = books.getOrDefault(5, "人性的弱点");
		System.out.println(bookName);
		
		bookName = books.get(5);
		System.out.println(bookName);
		
		books.putIfAbsent(5, "人性的弱点");
		books.putIfAbsent(5, "人性的弱点2");
		System.out.println("putIfAbsent : "+ books.get(5));
	}

}
