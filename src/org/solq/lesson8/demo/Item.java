package org.solq.lesson8.demo;

 
public class Item {
	/**
	 * 物品编号
	 */
	int id;
	/**
	 * 物品名称
	 */
	public String name;
	/**
	 * 库存
	 */
	public int num;
	/**
	 * 最小库存
	 */
	public int min;
	/**
	 * 最大库存
	 */
	int max;
	
	/**
	 * 每次进货
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

	/**在方法上加同步块 synchronized 相当于锁 Item 实例对象
	 * 只要是受保护的数据，并且业务操作要原子
	 * 只要是受保护的数据，保证同一时刻只有一个线程在拥有权限操作
	 * 多个方法加同步块 相当于互诉 多个业务操作操作
	 * **/
	public synchronized void buy() {
		//A 判断条件，B扣除数量
		if(this.num >0){
			this.num--;
		}
	}
	
	public synchronized void addValue(){
		this.num+=this.add;
	}
}
