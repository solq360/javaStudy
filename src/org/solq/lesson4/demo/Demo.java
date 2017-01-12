package org.solq.lesson4.demo;

public class Demo {
public static void main(String[] args) {
	User user = new User();
	
	SystemManage system =new SystemManage();
	ControlConfig[] configs = new ControlConfig[4];
	ControlConfig config = new ControlConfig();
	config.limit=800;
	config.gift=800;
	configs[0] =config ;
	
	ControlConfig config1 = new ControlConfig();
	config1.limit=700;
	config1.gift=400;
	configs[1] =config1 ;
	
	
	ControlConfig config2 = new ControlConfig();
	config2.limit=600;
	config2.gift=200;
	configs[2] =config2 ;
	
	ControlConfig config3 = new ControlConfig();
	config3.limit=500;
	config3.gift=100;
	configs[3] =config3 ;
	
	system.initConfig(configs);
	
	
	/////////////////////////业务代码////////////////////////////
	double buyValue =500d;
	system.monitoring(user, buyValue);
	
	System.out.println("用户消费多少钱 ："+ user.recordValue);
	System.out.println("系统返还多少钱 ："+ user.gift);
}
}
