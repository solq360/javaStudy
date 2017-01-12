package org.solq.lesson7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Lesson7 {

	//ctrl + f11
	public static void main(String[] args) {
		//map<ͼ���ţ�ͼ��>
		Map<Integer, String> books = new HashMap<>();
		books.put(1, "java�����ŵ�������ϵ��");
		books.put(2, "������ƾ�׵��");
		books.put(3, "��ְָ��ְ�");
		books.put(4, "��Ҫ�ò�����˼������");
		
		
		String bookName = books.get(1);
		System.out.println(bookName);
		
 		System.out.println("size:"+books.size());
 		System.out.println("isEmpty:"+books.isEmpty());
 		System.out.println("containsKey:"+books.containsKey(11));
 		System.out.println("containsValue:"+books.containsValue("��ְָ��ְ�"));
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
		bookName = books.getOrDefault(5, "���Ե�����");
		System.out.println(bookName);
		
		bookName = books.get(5);
		System.out.println(bookName);
		
		books.putIfAbsent(5, "���Ե�����");
		books.putIfAbsent(5, "���Ե�����2");
		System.out.println("putIfAbsent : "+ books.get(5));
	}

}
