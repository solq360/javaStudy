package org.solq.lesson12.demo.model;

/**
  * 操作库操作接口
 * @author solq
 * */
public interface IDB<IDTYPE,T  extends IData<IDTYPE>> {

	//create
	public T create(IDTYPE id,CallBack<IDTYPE,T> cb);
	
	//delete
	public void delete(IDTYPE id);
	
	//update
	public void update(T data);
	
	//search
	public T search(IDTYPE id);
}
