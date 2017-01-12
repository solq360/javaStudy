package org.solq.lesson3;

public class Lesson3 {

	public static void main(String[] args) {
		//所有的数字类型 要考虑 减去一半的数量 否则就会溢出
		//用变量来记录数据 int是整型 类型 32位
		int a = 2147483647;
		a=a+1;
		//短整形  16 	
		//short sa= 32768;
		//long 类型 64位
		long l = 2147483647;
		l=l+1;
		//双精度小数 64位
		double d = 122.0d;
		//单精度 32位 不考虑使用
		float f = 122.0f;
		//文本类型
		String s ="我是文本";
		//在解释编码时候用 ，一般情况下是不用的
		char c ='a';
		
		//真假状态 计算机存储是由 0 或者是1 来存 
		boolean b = true;
		boolean b1 = true;
		//System.out.println(sa);

		System.out.println(a);
		System.out.println(l);
		System.out.println(s);
		System.out.println(c);
		System.out.println(b);
		
		if(b && b1){
			System.out.println("我进来啦");
			System.out.println("我也进来啦");
		}
		
		
		///////////////////例子1////////////////////
		System.out.println("==============例子1============");
		//记录客户消费数量
		int recordValue = 750;
		//系统返还数量
		int gift = 0;
		
		if(recordValue >= 800){
			gift = 800;
		}else if(recordValue>=700){
			gift = 400;	
		}else if(recordValue>=600){
			gift = 200;	
		}else if(recordValue>=500){
			gift = 100;	
		}else{
			gift =0;
		}
		
		if(gift > 800){
			gift = 800;
		}
		
		System.out.println("系统赠送 ：" +gift);

	}

}
