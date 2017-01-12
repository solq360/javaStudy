package org.solq.lesson8.prepare;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/***
 * 进销存
 */
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		int min = 0;
		int max = 2;

		for (int i = 0; i < 100; i++) {
			int s = random(min, max);
			System.out.println(s);
		}
		List<Integer> items = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			items.add(i);
		}
		Repository repository = Repository.of();

		Runnable run1 = new Runnable() {

			@Override
			public void run() {

				while (!Thread.interrupted()) {
					Map<Integer, Item> datas = repository.datas;
					for (java.util.Map.Entry<Integer, Item> entry : datas.entrySet()) {
						Item item = entry.getValue();
						if (item.num <= item.min) {
							System.out.println("报警 ： " + item.id + " 剩余数量 ：" + item.num);
						}
					}
					try {
						Thread.sleep(1100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};
		Runnable run2 =new Runnable() {

			@Override
			public void run() {
				while (!Thread.interrupted()) {
					Map<Integer, Item> datas = repository.datas;

					for (int key = 1; key <= 8; key++) {
						Item item = datas.get(key);
						if (item.num > 0) {
							item.buy();
							break;
						}
					}
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}

				}

			}
		};
		Thread thread1 = new Thread(run1, "仓库监控");

		thread1.setDaemon(true);
		thread1.start();

		int count = 100;
		Thread[] workThreads = new Thread[count];
		for (int i = 0; i < count; i++) {
 			workThreads[i] = new Thread(run2, "物品出仓" + i);
			workThreads[i].setDaemon(true);
		}
		for (int i = 0; i < count; i++) {
			workThreads[i].start();
		}
		for (int i = 0; i < count; i++) {
			workThreads[i].join();
		}
		thread1.join();

		System.out.println("exit");
	}

	static Random RANDOM = new Random();

	private static int random(int min, int max) {
		return RANDOM.nextInt(max - min + 1) + min;
	}

}
