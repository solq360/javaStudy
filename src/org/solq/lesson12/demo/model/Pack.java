package org.solq.lesson12.demo.model;

public class Pack implements IData<String> {

	private String id;
	private String itemName;
	@Override
	public String getId() {
 		return id;
	}
	public String getItemName() {
		return itemName;
	}
	void setItemName(String itemName) {
		this.itemName = itemName;
	}
	void setId(String id) {
		this.id = id;
	}
	public static Pack of(String id, String itemName) {
		Pack ret = new Pack();
		ret.id=id;
		ret.itemName = itemName;
		return ret;
	}

}
