package org.solq.lesson6.prepare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lesson6 {
public static void main(String[] args) {
	List<Integer> list= new ArrayList<>();
	Collections.shuffle(list);
	Collections.sort(list);
	//Collections.addAll(c, elements);
	
	int[] intList = {4,5};
	int[] copyList =new int[3];
	System.out.println(copyList[1]);
	System.arraycopy(intList, 0, copyList, 0, 2);
	System.out.println(copyList[1]);
  }
}
