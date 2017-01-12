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
	// <�ļ���,JAVA�ļ�����Դ>
	private Map<String, DownFileObject> cahceFiles = new HashMap<>();
	// <�ļ���,������>
	private Map<String, Object> locks = new HashMap<>();

	private ReadWriteLock rwLock = new ReentrantReadWriteLock();
	protected long time = 1000 * 60;

	private Thread autoClostThread = new Thread(new Runnable() {
		public void run() {

			while (!Thread.interrupted()) {
				// �����Ǵ���ֻ�����ݣ�ֻ���õ�ʱ�Ŀ��վͿ����ˣ��������ԭ��ֻ����Ҫ���������ݣ������߼���Ҫ��������
				Map<String, DownFileObject> tmp = null;
				// ������
				rwLock.readLock().lock();
				try {
					tmp = new HashMap<>(cahceFiles);
				} finally {
					rwLock.readLock().unlock();
				}

				long now = System.currentTimeMillis();
				Set<String> closeFiles = new HashSet<>();
				// ��ʼ���ݴ���
				for (Entry<String, DownFileObject> entry : tmp.entrySet()) {
					// ����ʱ���޷��ʹ��͹ر�ɾ��
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
	}, "�Զ��ͷ��ļ���Դ");

	/**
	 * �����ļ�
	 * 
	 * @param fileName
	 *            �ļ���
	 * @param startPos
	 *            �����ļ���ָλ��
	 * @param contentLeng
	 *            ���ݳ���
	 */
	public byte[] downFile(String fileName, int startPos, int contentLeng) {
		byte[] ret = null;

		// ת����ȷ���ļ���
		File file = new File(fileName);
		fileName = file.getAbsolutePath();

		// ��ȡ��
		Object lock = locks.get(fileName);
		if (lock == null) {
			synchronized (this) {
				// ���μ�� double check
				lock = locks.get(fileName);
				if (lock == null) {
					lock = new Object();
					locks.put(fileName, lock);
				}
			}
 		}

		// �ӻ�����ļ������ҵ��ļ���Դ
		DownFileObject r = cahceFiles.get(fileName);
		// �����ļ�
		synchronized (lock) {
			// double check
			r = cahceFiles.get(fileName);
			if (r == null) {
				r = DownFileObject.of(fileName);
				cahceFiles.put(fileName, r);
			}
			RandomAccessFile soure = r.getSoure();
			// ʣ��ɶ����ݳ���
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
