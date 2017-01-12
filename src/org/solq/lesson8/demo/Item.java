package org.solq.lesson8.demo;

 
public class Item {
	/**
	 * ��Ʒ���
	 */
	int id;
	/**
	 * ��Ʒ����
	 */
	public String name;
	/**
	 * ���
	 */
	public int num;
	/**
	 * ��С���
	 */
	public int min;
	/**
	 * �����
	 */
	int max;
	
	/**
	 * ÿ�ν���
	 */
	int add;

	public static Item of(int id, String name, int num, int min, int max, int add) {
		Item ret = new Item();
		ret.id=id;
		ret.name = name;
		ret.num = num;
		ret.min = min;
		ret.max = max;
		ret.add =add;
		return ret;
	}

	/**�ڷ����ϼ�ͬ���� synchronized �൱���� Item ʵ������
	 * ֻҪ���ܱ��������ݣ�����ҵ�����Ҫԭ��
	 * ֻҪ���ܱ��������ݣ���֤ͬһʱ��ֻ��һ���߳���ӵ��Ȩ�޲���
	 * ���������ͬ���� �൱�ڻ��� ���ҵ���������
	 * **/
	public synchronized void buy() {
		//A �ж�������B�۳�����
		if(this.num >0){
			this.num--;
		}
	}
	
	public synchronized void addValue(){
		this.num+=this.add;
	}
}
