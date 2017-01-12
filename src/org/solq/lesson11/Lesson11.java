package org.solq.lesson11;

public class Lesson11 {

	/** 定义一个两个数学相加的函数 */
	static int addNum(int a, int b) {
		return a + b;
	}

	/** 定义一个取两个数学最大值的函数 */
	private static int maxNum(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	
	void yell(Ctx ctx){
		
	}
	
	public static void main(String[] args) {
		System.out.println("addNum:" + addNum(1, 2));
		System.out.println("maxNum:" + maxNum(1, 2));
		System.out.println("math max:" + Math.max(1, 2));

	}

}
