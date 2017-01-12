package org.solq.lesson12.demo.manage;

import java.util.HashMap;
import java.util.Map;

import org.solq.lesson12.demo.model.CallBack;
import org.solq.lesson12.demo.model.IDB;
import org.solq.lesson12.demo.model.IData;

/**
 * 内存数据库模板类
 * @author solq
 * */
public  class CacheDBTemplate<IDTYPE,DATA  extends IData<IDTYPE>> implements IDB<IDTYPE,DATA>{
	/**内存数据**/
	private final Map<IDTYPE, DATA> cacheData = new HashMap<>();

	public static int a= 100;
	@Override
	public DATA create(IDTYPE id, CallBack<IDTYPE,DATA> cb) {
		DATA ret = search(id);
		if( ret==null){
			ret=cb.run(id);
			cacheData.put(id, ret);
		}
		return  ret;
	}

	@Override
	public void delete(IDTYPE id) {
		cacheData.remove(id);		
	}

	@Override
	public void update(DATA data) {
		cacheData.put(data.getId(), data);		
	}

	@Override
	public DATA search(IDTYPE id) {
		DATA ret = cacheData.get(id);
		return  ret;
	}
	 
	
}