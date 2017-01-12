package org.solq.lesson6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lesson6 {

	public static void main(String[] args) {
		int[] intArray = new int[2];
		intArray[0] =1;
		intArray[1] =2;
 		
		int[] newArray = new int[3];
		newArray[0]=intArray[0];
		newArray[1]=intArray[1];
		newArray[2]=3;
		
		
		List<Integer> list = new ArrayList<>(2);
		list.add(3);
		list.add(2);
		list.add(1);
		
		
		System.out.println("size : " + list.size());
		System.out.println("isEmpty : " + list.isEmpty());
		//list.remove(1);
 		System.out.println("isEmpty : " + list.get(1));
 		System.out.println("contains : " + list.contains(11));

 		//�������� ���Դ��������ͬ���͵����ݣ������˹���������Щ�������Ǻܷ����ģ������壬�޼�ֵ
 		
 		//�������  for(��һ���ǳ�ʼ���ν�ִ�� ; �ڶ�����ѭ���������� ; ��������ѭ����ִ��;)
 		for(int index= 0; index<list.size() ; index++ ){
 			System.out.println("list �±� �� "+  index + " ���� �� "+ list.get(index));
 		}
 		
 		
 		Set<Integer> set= new HashSet<>();
 		set.add(1);
 		set.add(1);
 		set.add(3);
 		
 		for(Integer value : set ){
 			System.out.println("set ���� �� "+  value);
 		}

 		//Collections.shuffle(list);
 		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int ret  = o1-o2;
				System.out.println(" ret"   + ret + " o1 " + o1+" o2 " + o2);
 				return -ret;
			}
		});
 		for(Integer value : list ){
 			System.out.println("list ���� �� "+  value);
 		}
 		
	}
}
