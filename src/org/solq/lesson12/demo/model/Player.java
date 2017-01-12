package org.solq.lesson12.demo.model;

public class Player implements IData<Long> {

	private long id;
	private String name;
	private int sex;
	
	
	public static Player of(Long id, String name, int sex) {
		Player ret = new Player();
		ret.id=id;
		ret.name=name;
		ret.sex=sex;
		return ret;
	}
	//getter 

	@Override
	public Long getId() {
 		return id;
	}
	public String getName() {
		return name;
	}
	public int getSex() {
		return sex;
	}


	//setter
	void setId(long id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setSex(int sex) {
		this.sex = sex;
	}

	
}
