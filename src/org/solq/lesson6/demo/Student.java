package org.solq.lesson6.demo;

/**
 * 学生
 */
public class Student {

	/**
	 * 学生名
	 */
	String name;
	/**
	 * 获得分数
	 */
	int score;

	public static Student of(String name, int score) {
		Student ret = new Student();
		ret.name = name;
		ret.score = score;
		return ret;
	}
}
