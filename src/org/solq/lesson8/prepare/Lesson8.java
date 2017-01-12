package org.solq.lesson8.prepare;

public class Lesson8 {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (!Thread.interrupted()) {
					System.out.println("正在执行任务：" + i);
					i++;
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
 						e.printStackTrace();
					}
					if (i == 20) {
						System.out.println(Thread.activeCount());
						System.out.println("thread state : " + Thread.currentThread().getState().name());
						Thread.currentThread().interrupt();
					}
				}
				System.out.println("thread state : " + Thread.currentThread().getState().name());
			}
		});
 		t.setDaemon(true);
		t.setName("测试线程");
		System.out.println("thread state : " + t.getState().name());
		t.start();
		System.out.println("thread state : " + t.getState().name());

		t.join();
		System.out.println("thread state : " + t.getState().name());
 		while (true) {
			Thread.sleep(400);
		}
		// Thread.sleep(millis);
		// Thread.yield();
		// Thread.currentThread().getName()
		// Thread.currentThread().getState()
		// Thread.interrupted()
	}

}
