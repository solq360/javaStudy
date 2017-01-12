package org.solq.lesson6.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		Student s1 = Student.of("学生1",50);
		Student s2 = Student.of("学生2",54);
		Student s3 = Student.of("学生3",54);
		Student s4 = Student.of("学生4",54);
		Student s5 = Student.of("学生5",55);
		Student s6 = Student.of("学生6",56);
		Student s7 = Student.of("学生7",57);
		
		List<Student> list = new ArrayList<>(7);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		list.add(s1);
		
 
		List<Student> newList = Arrays.asList(Student.of("学生1",50),
				Student.of("学生2",54),
				 Student.of("学生3",54),
				 Student.of("学生4",54),
				 Student.of("学生5",55),
				 Student.of("学生6",56),
				 Student.of("学生7",57)
				);
		
		newList.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
 				return-( o1.score-o2.score);
			}
		});
		
		for(Student s : newList){
			System.out.println("名称："+ s.name + " 分数："+s.score);
		}
	}
}
