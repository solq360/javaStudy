package org.solq.lesson6.demo;

/**
 * ѧ��
 */
public class Student {

	/**
	 * ѧ����
	 */
	String name;
	/**
	 * ��÷���
	 */
	int score;

	public static Student of(String name, int score) {
		Student ret = new Student();
		ret.name = name;
		ret.score = score;
		return ret;
	}
}
