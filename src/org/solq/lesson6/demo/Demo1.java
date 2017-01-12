package org.solq.lesson6.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		Student s1 = Student.of("ѧ��1",50);
		Student s2 = Student.of("ѧ��2",54);
		Student s3 = Student.of("ѧ��3",54);
		Student s4 = Student.of("ѧ��4",54);
		Student s5 = Student.of("ѧ��5",55);
		Student s6 = Student.of("ѧ��6",56);
		Student s7 = Student.of("ѧ��7",57);
		
		List<Student> list = new ArrayList<>(7);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		
 
		List<Student> newList = Arrays.asList(Student.of("ѧ��1",50),
				Student.of("ѧ��2",54),
				 Student.of("ѧ��3",54),
				 Student.of("ѧ��4",54),
				 Student.of("ѧ��5",55),
				 Student.of("ѧ��6",56),
				 Student.of("ѧ��7",57)
				);
		
		newList.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
 				return-( o1.score-o2.score);
			}
		});
		
		for(Student s : newList){
			System.out.println("���ƣ�"+ s.name + " ������"+s.score);
		}
	}
}
