package org.solq.lesson12.demo.manage;

import java.util.HashMap;
import java.util.Map;

import org.solq.lesson12.demo.model.CallBack;
import org.solq.lesson12.demo.model.IDB;
import org.solq.lesson12.demo.model.Player;

public class CacheDBManage implements IDB<Long,Player>{

	/**内存数据**/
	private Map<Long, Player> cacheData = new HashMap<>();
	
	
	/***
	 * 创建数据，逻辑 先查询有没有这个ID的数据，没有再创建,
	 * 因为底层核心代码是不知道业务层具体的逻辑跟属性，这时间可以传一个回调的执行方法来解决
	 * */
	@Override
	public Player create(Long id,CallBack<Long,Player> cb) {
		Player ret = search(id);
		if( ret==null){
			ret=cb.run(id);
			cacheData.put(id, ret);
		}
		return  ret;
	}

	@Override
	public void delete(Long id) {
		cacheData.remove(id);
	}

	@Override
	public void update(Player data) {
		cacheData.put(data.getId(), data);
	}

	@Override
	public Player search(Long id) {
		Player ret = cacheData.get(id);
		return  ret;
	}

}
