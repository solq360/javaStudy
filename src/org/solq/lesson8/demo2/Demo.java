package org.solq.lesson8.demo2;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

import org.solq.lesson8.demo.Item;
import org.solq.lesson8.demo.Repository;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		Repository repository = Repository.of();

		//锁对象 任何对象，为什么是个对象， 实际它的底层就是一个锁 address 
		//Object lockObj = new Object();
		
		// 每秒监控所有物品
		Runnable target = new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					Map<Integer, Item> items = repository.items;

					for (Entry<Integer, Item> entry : items.entrySet()) {
						Item item = entry.getValue();

						if (item.num <= item.min) {
							System.out.println("报警:" + item.name + " 剩余数量 :" + item.num);
						}
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(target, "监控线程");
		thread.setDaemon(true);
		thread.start();

		// 出仓线程
		Runnable workTask = new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					Map<Integer, Item> items = repository.items;

					for (int i = 1; i <= 8; i++) {
						Item item = items.get(i);
						//当多个线程同时修改数据的时候，如果不进行保护操作，就会产生脏处理
//						synchronized (Demo.class) {
//							
//						}
						item.buy();
					}
				}
			}
		};

		int count =20;
		Thread[] workThreads = new Thread[count];
		for (int i = 0; i < count; i++) {
			workThreads[i] = new Thread(workTask, "出仓线程" + i);
			workThreads[i].setDaemon(true);
		}
		for (int i = 0; i < count; i++) {
			workThreads[i].start();
		}

		for (int i = 0; i < count; i++) {
			workThreads[i].join();
		}
		thread.join();

		System.out.println("主进程结束");
	}

}
