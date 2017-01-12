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
		FileInputStream is = new FileInputStream("C:/Users/Administrator/Desktop/录像/test.txt");
		FileOutputStream os = new FileOutputStream("C:/Users/Administrator/Desktop/录像/test_cp.txt");
		FileChannel ic = is.getChannel();
		FileChannel oc = os.getChannel();
		
 
 		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
 		byteBuffer.clear();
 		while (ic.read(byteBuffer)!= -1) {
			//写操作时候 byteBuffer 要锁定byte对象的边界对行
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
		RandomAccessFile r = new RandomAccessFile("C:/Users/Administrator/Desktop/录像/test.txt", "rw");
		System.out.println("文件大小:" + r.length());
		System.out.println("文件指针位置:" + r.getFilePointer());
		r.seek(20);
		r.readChar();

		System.out.println("读数据后文件指针位置:" + r.getFilePointer());

		r.writeByte(2);
		System.out.println("写数据后文件指针位置:" + r.getFilePointer());

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
			writer.println("邮件系统,0.2,7,小白,小红,");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void test_buff_byteStream() throws FileNotFoundException, IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(
				"C:/Users/Administrator/Desktop/录像/java从入门到卖肠粉系列(solq)lesson13-1文件IO[File操作基础].rar"), 1 << 16);
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
				"C:/Users/Administrator/Desktop/录像/java从入门到卖肠粉系列(solq)lesson13-1文件IO[File操作基础].rar");
		OutputStream os = new FileOutputStream(
				"C:/Users/Administrator/Desktop/录像/java从入门到卖肠粉系列(solq)lesson13-1文件IO[File操作基础]cp.rar");
		int ret = 0;
		long start = System.currentTimeMillis();
		// 流来的，所以要循环读取
		// 每次去硬盘读是很慢的，所以用内存去换操作次数
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
		System.out.println("是否是文件夹或文件 ：" + file.exists());
		System.out.println("是否是文件夹 ：" + file.isDirectory());

	}

	static void test1() {
		File file = new File("c:/app");

		System.out.println("是否是文件夹或文件 ：" + file.exists());
		System.out.println("是否是文件夹 ：" + file.isDirectory());
		System.out.println("是否为文件 ：" + file.isFile());
		System.out.println("最后修改时间 ：" + file.lastModified());
		System.out.println("绝对路径 ：" + file.getAbsolutePath());

		String[] files = file.list();
		for (String f : files) {
			System.out.println("文件列表 ：" + f);
		}
	}
}
