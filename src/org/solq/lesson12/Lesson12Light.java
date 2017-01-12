package org.solq.lesson12;

import org.solq.lesson12.model.Green;
import org.solq.lesson12.model.ILight;
import org.solq.lesson12.model.LightType;
import org.solq.lesson12.model.Red;
import org.solq.lesson12.model.Yellow;

public class Lesson12Light {

	public static void main(String[] args) throws InterruptedException {
		//面向接口书写，有个好处是不需要知到具体是那个实现的子类，建构时可任意替换
		
		ILight[] lights = {new Green(), new Yellow(),new Red(),new Yellow()};
		
		//模拟交通灯一秒一秒的跑
		while(true){
			
			//获得系统当前时间 毫秒单位
			long start = System.currentTimeMillis();
			long end  = 0L;
			LightType swType = null;
			for(ILight light : lights){
				//当切换不同类型灯的时候 记录开始时间
				if(swType ==null || !light.getType().equals(swType)){
					//记录切换的时间
					start = System.currentTimeMillis();
					end  = start+ light.getExTime()*1000;
					//记录当前已执行的交通灯
					swType = light.getType();
				}
 
				
				int value =1;
				//当前系统时间比结束时间少
				while(System.currentTimeMillis()< end){
					System.out.println("当前灯类型 ："+ swType + " 执行时间 ：" + value);
					Thread.sleep(1000);
					value++;
				}
				
				//切换条件，时间结束切换下一个
				swType=null;
			}
		}
	}

}
