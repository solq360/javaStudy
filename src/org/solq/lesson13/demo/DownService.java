package org.solq.lesson13.demo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DownService {
	// <文件名,JAVA文件流资源>
	private Map<String, DownFileObject> cahceFiles = new HashMap<>();
	// <文件名,锁对象>
	private Map<String, Object> locks = new HashMap<>();

	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	protected long time = 1000 * 60;

	private Thread autoClostThread = new Thread(new Runnable() {
		public void run() {

			while (!Thread.interrupted()) {
				// 当我们处理只读数据，只是拿当时的快照就可以了，锁代码块原则只锁需要保护的数据，其它逻辑不要包括在内
				Map<String, DownFileObject> tmp = null;
				// 锁保护
				rwLock.readLock().lock();
				try {
					tmp = new HashMap<>(cahceFiles);
				} finally {
					rwLock.readLock().unlock();
				}

				long now = System.currentTimeMillis();
				Set<String> closeFiles = new HashSet<>();
				// 开始数据处理
				for (Entry<String, DownFileObject> entry : tmp.entrySet()) {
					// 超过时间无访问过就关闭删除
					if (now > (entry.getValue().getLastAcess() + time)) {
						closeFiles.add(entry.getKey());
					}
				}

				rwLock.writeLock().lock();
				try {
					for (String file : closeFiles) {
						Object lock = locks.get(file);
						synchronized (lock) {
							DownFileObject r = cahceFiles.remove(file);
							r.close();
						}
					}
				} finally {
					rwLock.writeLock().unlock();
				}

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}, "自动释放文件资源");

	/**
	 * 下载文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param startPos
	 *            访问文件针指位置
	 * @param contentLeng
	 *            内容长度
	 */
	public byte[] downFile(String fileName, int startPos, int contentLeng) {
		byte[] ret = null;

		// 转换正确的文件名
		File file = new File(fileName);
		fileName = file.getAbsolutePath();

		// 获取锁
		Object lock = locks.get(fileName);
		if (lock == null) {
			synchronized (this) {
				// 两次检查 double check
				lock = locks.get(fileName);
				if (lock == null) {
					lock = new Object();
					locks.put(fileName, lock);
				}
			}
 		}

		// 从缓存的文件池里找到文件资源
		DownFileObject r = cahceFiles.get(fileName);
		// 访问文件
		synchronized (lock) {
			// double check
			r = cahceFiles.get(fileName);
			if (r == null) {
				r = DownFileObject.of(fileName);
				cahceFiles.put(fileName, r);
			}
			RandomAccessFile soure = r.getSoure();
			// 剩余可读内容长度
			try {
				Long surplusLen = soure.length() - startPos;
				int min = Math.min(surplusLen.intValue(), contentLeng);
				if (min < 0) {
					return new byte[0];
				}

				soure.seek(startPos);
				ret = new byte[min];
				soure.read(ret);
			} catch (IOException e) {
				e.printStackTrace();
			}
			r.refresh();
		}
		return ret;
	}

	public void start() {
		this.autoClostThread.setDaemon(true);
		this.autoClostThread.start();
	}
}
