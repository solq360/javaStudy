package org.solq.lesson12.demo;

import org.solq.lesson12.demo.manage.CacheDBTemplate;
import org.solq.lesson12.demo.manage.PackCacheManage;
import org.solq.lesson12.demo.manage.PlayerCacheManage;
import org.solq.lesson12.demo.model.CallBack;
import org.solq.lesson12.demo.model.Pack;
import org.solq.lesson12.demo.model.Player;

public class TemplDemo {

	public static void main(String[] args) {
		
		PlayerCacheManage db = new PlayerCacheManage();
		
		long playerId = 1L;
		Player data = db.search(playerId);
		System.out.println("��ѯ���� ��" + data);

		// ���Դ�������
		data = db.create(playerId, new CallBack<Long,Player>() {

			@Override
			public Player run(Long id) {
				return Player.of(id, "solq", 0);
			}
		});

		System.out.println("�Ѵ����������� ��" + data.getId());
		
		
		data = db.search(playerId);
		System.out.println("�ٲ�ѯ���� ��" + data);
		
		
		PackCacheManage cm = new PackCacheManage();
		
		Pack pack=cm.create("1", new CallBack<String, Pack>() {
			
			@Override
			public Pack run(String id) {
 				return Pack.of(id,"solq RMBһ��99������");
			}
		});
		
		System.out.println("�Ѵ����������� ��" + pack.getItemName());

		
		CacheDBTemplate<Long,Player> cp = new CacheDBTemplate<>();
		CacheDBTemplate<String,Pack> pct = new CacheDBTemplate<>();
		CacheDBTemplate.a=1111;
	}
}
