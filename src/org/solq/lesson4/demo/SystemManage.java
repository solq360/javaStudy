package org.solq.lesson4.demo;

public class SystemManage {
	ControlConfig[] configs;
	/***
	 * 初始化配置
	 * */
	void initConfig(ControlConfig[] configs){
		//this 可以访问类 的内部属性 跟方法
		this.configs = configs;
	}
	/***
	 * 监控用户购买多少钱，并且返还给用户
	 * */
	void monitoring(User user,double buyValue){
		user.buy(buyValue);
		ControlConfig config1=configs[0];
		ControlConfig config2=configs[1];
		ControlConfig config3=configs[2];
		ControlConfig config4=configs[3];
		
		if(buyValue>=config1.limit){
			user.addGift(config1.gift);
		}else if(buyValue>=config2.limit){
			user.addGift(config2.gift);
		}else if(buyValue>=config3.limit){
			user.addGift(config3.gift);
		}else if(buyValue>=config4.limit){
			user.addGift(config4.gift);
		}
	}
}
