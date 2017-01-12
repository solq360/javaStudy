package org.solq.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Lesson10 {

	public static void main(String[] args) {
		String item = "包子";
		if (item.equals("包子")) {
			System.out.println("买四个包子");
		} else if (item.equals("西瓜")) {
			System.out.println("买1个包子");
		}else{
			System.out.println("什么也不买");
		}
		
		for(int i=1;i<=1000000;i++){
			if(i==2){
				//忽略下面所有
				continue;
			}
			if(i==4){
				System.out.println("买1个西瓜");
			}
			if(i==7){
				System.out.println("买2个西瓜");
			}
			if(i==8){
				System.out.println("买4个西瓜");
			}
			if(i==10){
				System.out.println("买4个西瓜");
			}
			
			if(i==20){
				//跳出循环
				break;
			}
		}
		
		//只能根据单一的状态处理控制
		switch (item) {
		case "包子":
			System.out.println("买四个包子");
			break;
		case "西瓜":
			System.out.println("买1个包子");
			break;
		default:
			System.out.println("什么也不买");
			break;
		}
		
		//map<控制状态，控制器> 预先把控制关联 关联起来
		Map<String, String> map = new HashMap<>();
		map.put("包子", "买四个包子");
		map.put("西瓜", "买1个包子");
		
		String text= map.get(item);
		System.out.println(text);
	}

}
