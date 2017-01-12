package org.solq.lesson11.prepare;

public interface Service {
	int store();
	int charge(int money);
	int vipChannel();
	int registerName(String name,String identity);
	int buyFlow(int money);
}
