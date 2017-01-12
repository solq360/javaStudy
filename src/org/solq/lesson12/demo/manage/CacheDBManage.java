package org.solq.lesson12.demo.manage;

import java.util.HashMap;
import java.util.Map;

import org.solq.lesson12.demo.model.CallBack;
import org.solq.lesson12.demo.model.IDB;
import org.solq.lesson12.demo.model.Player;

public class CacheDBManage implements IDB<Long,Player>{

	/**�ڴ�����**/
	private Map<Long, Player> cacheData = new HashMap<>();
	
	
	/***
	 * �������ݣ��߼� �Ȳ�ѯ��û�����ID�����ݣ�û���ٴ���,
	 * ��Ϊ�ײ���Ĵ����ǲ�֪��ҵ��������߼������ԣ���ʱ����Դ�һ���ص���ִ�з��������
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
