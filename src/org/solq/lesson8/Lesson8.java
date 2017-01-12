package org.solq.lesson8;

public class Lesson8 {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("���������������� :" + Thread.currentThread().getName());
				System.out.println("�鿴����ִ��״̬ :" + Thread.currentThread().getState());
				int count = 500;
				// �����ǰ�̲߳��жϵĻ� ��ѭ��
				while (!Thread.interrupted()) {
					if (count-- <= 0) {
						//Thread.currentThread().interrupt();
						//System.out.println("ִ���жϴ���===========================");
						//����ҵ����� ��֤��Ҫ����
						try {
							 throw new RuntimeException("");
						} catch (Exception e) {
							 
						}
						
					}
				}
				System.out.println("�����߳̽���");
			}
		};
		Thread thread = new Thread(runnable, "�����߳�");
		System.out.println("�鿴����״̬ :" + thread.getState().name());

		thread.setDaemon(true);
		thread.start();
		System.out.println("�鿴ִ��״̬ :" + thread.getState().name());
		System.out.println("activeCount:" + Thread.activeCount());

		// ���������̣����̽������ӽ���һ�����
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�鿴����״̬ :" + thread.getState().name());
		System.out.println("activeCount:" + Thread.activeCount());

		// �����̣��ڸ���������
		System.out.println("����ִ��");
	}

}
