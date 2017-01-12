package org.solq.lesson13.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public class FileChannelStream implements IFileChannel {

	// 输入文件
	private FileChannel ic;

	// 多个输出文件
	private Map<String, FileChannel> ocMap = new HashMap<>();

	// 缓冲byte
	private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

	public FileChannelStream(String string) {
		try   {
			FileInputStream is = new FileInputStream("C:/Users/Administrator/Desktop/录像/test.txt");
			ic = is.getChannel();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	@Override
	public synchronized void pipe(String... files) {
		for (String file : files) {
			String key = new File(file).getAbsolutePath();
			FileChannel oc = ocMap.get(key);
			if (oc == null) {
				try  {
 					oc =  new FileOutputStream(key).getChannel();
					ocMap.put(key, oc);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public synchronized void sync() {

		byteBuffer.clear();
		try {
			while (ic.read(byteBuffer) != -1) {
				// 写数据前要记录数据的坐标
				int mark = byteBuffer.position();
				for (FileChannel oc : ocMap.values()) {
					// 写操作时候 byteBuffer 要锁定byte对象的边界才行
					byteBuffer.flip();
					oc.write(byteBuffer);
					// 写完后，恢复数据坐标
					byteBuffer.position(mark);
				}
				byteBuffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void close() {

		try {
			ic.close();
			for (FileChannel oc : ocMap.values()) {
				oc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
