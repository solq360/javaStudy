package org.solq.lesson13;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Lesson13 {

	public static void main(String[] args) throws IOException {
		FileInputStream is = new FileInputStream("C:/Users/Administrator/Desktop/¼��/test.txt");
		FileOutputStream os = new FileOutputStream("C:/Users/Administrator/Desktop/¼��/test_cp.txt");
		FileChannel ic = is.getChannel();
		FileChannel oc = os.getChannel();
		
 
 		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
 		byteBuffer.clear();
 		while (ic.read(byteBuffer)!= -1) {
			//д����ʱ�� byteBuffer Ҫ����byte����ı߽����
 			byteBuffer.flip();
 			oc.write(byteBuffer);
 			byteBuffer.clear();
		}
		oc.close();
		ic.close();
		os.close();
		is.close();
	}

	private static void test_randomassess() throws FileNotFoundException, IOException {
		RandomAccessFile r = new RandomAccessFile("C:/Users/Administrator/Desktop/¼��/test.txt", "rw");
		System.out.println("�ļ���С:" + r.length());
		System.out.println("�ļ�ָ��λ��:" + r.getFilePointer());
		r.seek(20);
		r.readChar();

		System.out.println("�����ݺ��ļ�ָ��λ��:" + r.getFilePointer());

		r.writeByte(2);
		System.out.println("д���ݺ��ļ�ָ��λ��:" + r.getFilePointer());

		r.close();
	}

	static void test_char_stream() {
		try (LineNumberReader reader = new LineNumberReader(new FileReader("C:/Users/Administrator/Desktop/test.csv"));
				PrintWriter writer = new PrintWriter(
						new FileWriter("C:/Users/Administrator/Desktop/test.csv", true));) {

			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(" line num :  " + reader.getLineNumber());
			writer.println("�ʼ�ϵͳ,0.2,7,С��,С��,");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void test_buff_byteStream() throws FileNotFoundException, IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(
				"C:/Users/Administrator/Desktop/¼��/java�����ŵ�������ϵ��(solq)lesson13-1�ļ�IO[File��������].rar"), 1 << 16);
		int ret = 0;
		long start = System.currentTimeMillis();
		byte[] buf = new byte[1 << 16];

		while ((ret = is.read(buf)) != -1) {
		}
		long end = System.currentTimeMillis();

		is.close();
		System.out.println(end - start);
	}

	static void test_base_byteStream() throws FileNotFoundException, IOException {
		InputStream is = new FileInputStream(
				"C:/Users/Administrator/Desktop/¼��/java�����ŵ�������ϵ��(solq)lesson13-1�ļ�IO[File��������].rar");
		OutputStream os = new FileOutputStream(
				"C:/Users/Administrator/Desktop/¼��/java�����ŵ�������ϵ��(solq)lesson13-1�ļ�IO[File��������]cp.rar");
		int ret = 0;
		long start = System.currentTimeMillis();
		// �����ģ�����Ҫѭ����ȡ
		// ÿ��ȥӲ�̶��Ǻ����ģ��������ڴ�ȥ����������
		byte[] buf = new byte[1 << 16];
		while ((ret = is.read(buf)) != -1) {
			os.write(buf);
		}
		long end = System.currentTimeMillis();

		is.close();
		os.close();
		System.out.println(end - start);
	}

	static void test_file() {
		File file = new File("c:/a/b/c/d.txt");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�Ƿ����ļ��л��ļ� ��" + file.exists());
		System.out.println("�Ƿ����ļ��� ��" + file.isDirectory());

	}

	static void test1() {
		File file = new File("c:/app");

		System.out.println("�Ƿ����ļ��л��ļ� ��" + file.exists());
		System.out.println("�Ƿ����ļ��� ��" + file.isDirectory());
		System.out.println("�Ƿ�Ϊ�ļ� ��" + file.isFile());
		System.out.println("����޸�ʱ�� ��" + file.lastModified());
		System.out.println("����·�� ��" + file.getAbsolutePath());

		String[] files = file.list();
		for (String f : files) {
			System.out.println("�ļ��б� ��" + f);
		}
	}
}
