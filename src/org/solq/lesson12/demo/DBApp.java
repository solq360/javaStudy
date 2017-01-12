package org.solq.lesson12.demo;

import org.solq.lesson12.demo.manage.CacheDBManage;
import org.solq.lesson12.demo.model.CallBack;
import org.solq.lesson12.demo.model.Player;

public class DBApp {

	public static void main(String[] args) {
		CacheDBManage db = new CacheDBManage();
		long playerId = 1L;
		Player data = db.search(playerId);
		System.out.println("查询数据 ：" + data);

		// 测试创建数据
		data = db.create(playerId, new CallBack<Long,Player>() {

			@Override
			public Player run(Long id) {
				return Player.of(id, "solq", 0);
			}
		});

		System.out.println("已创建创建数据 ：" + data.getId());
		
		
		data = db.search(playerId);
		System.out.println("再查询数据 ：" + data);
	}

}
