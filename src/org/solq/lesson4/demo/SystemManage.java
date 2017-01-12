package org.solq.lesson4.demo;

public class SystemManage {
	ControlConfig[] configs;
	/***
	 * ��ʼ������
	 * */
	void initConfig(ControlConfig[] configs){
		//this ���Է����� ���ڲ����� ������
		this.configs = configs;
	}
	/***
	 * ����û��������Ǯ�����ҷ������û�
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
