package org.solq.lesson13.demo;

public class TestDownService {

	public static void main(String[] args) throws InterruptedException {
		DownService downService = new DownService();
		downService.start();
		String fileName = "C:/Users/Administrator/Desktop/Â¼Ïñ/test.txt";
		
		int count=50;
		Thread[] threads = new Thread[count];
		for(int i =0;i<count;i++){
			int t = i;
			threads[i]=new Thread(  new Runnable() {
				public void run() {
					byte[] bytes= downService.downFile(fileName , 10+t*2, 1000000);
					System.out.println(Thread.currentThread().getName()+":"+bytes.length);
				}
			});
		}
		
		
		for(int i =0;i<count;i++){
			threads[i].setDaemon(true);
			threads[i].start();
		}
		
		for(int i =0;i<count;i++){
 			threads[i].join();
		}
	}
}
