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

	// �����ļ�
	private FileChannel ic;

	// �������ļ�
	private Map<String, FileChannel> ocMap = new HashMap<>();

	// ����byte
	private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

	public FileChannelStream(String string) {
		try   {
			FileInputStream is = new FileInputStream("C:/Users/Administrator/Desktop/¼��/test.txt");
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
				// д����ǰҪ��¼���ݵ�����
				int mark = byteBuffer.position();
				for (FileChannel oc : ocMap.values()) {
					// д����ʱ�� byteBuffer Ҫ����byte����ı߽����
					byteBuffer.flip();
					oc.write(byteBuffer);
					// д��󣬻ָ���������
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
