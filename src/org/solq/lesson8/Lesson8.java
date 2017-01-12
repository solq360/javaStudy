package org.solq.lesson8;

public class Lesson8 {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("哈哈，我跑起来啦 :" + Thread.currentThread().getName());
				System.out.println("查看正在执行状态 :" + Thread.currentThread().getState());
				int count = 500;
				// 如果当前线程不中断的话 死循环
				while (!Thread.interrupted()) {
					if (count-- <= 0) {
						//Thread.currentThread().interrupt();
						//System.out.println("执行中断处理===========================");
						//包着业务代码 保证不要出错
						try {
							 throw new RuntimeException("");
						} catch (Exception e) {
							 
						}
						
					}
				}
				System.out.println("测试线程结束");
			}
		};
		Thread thread = new Thread(runnable, "测试线程");
		System.out.println("查看创建状态 :" + thread.getState().name());

		thread.setDaemon(true);
		thread.start();
		System.out.println("查看执行状态 :" + thread.getState().name());
		System.out.println("activeCount:" + Thread.activeCount());

		// 加入主进程，主程进等侍子进程一起结束
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("查看结束状态 :" + thread.getState().name());
		System.out.println("activeCount:" + Thread.activeCount());

		// 主进程，在干其它事情
		System.out.println("结束执行");
	}

}
