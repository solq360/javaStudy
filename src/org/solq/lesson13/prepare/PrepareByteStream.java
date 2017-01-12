package org.solq.lesson13.prepare;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrepareByteStream {

	public static void main(String[] args) throws IOException {
		String fileName = "C:/Users/Administrator/Desktop/录像/java从入门到卖肠粉系列(solq)lesson13-1文件IO[File操作基础].rar";
		// String fileName =
		// "C:/Users/Administrator/Desktop/录像/java课程(solq).pdf";
		File f1 = new File(fileName);
		byte[] buffer = new byte[1 << 20];

		InputStream is1 = new BufferedInputStream(new FileInputStream(f1));
		int ret1 = 0;
		long start = System.currentTimeMillis();
		while ((ret1 = is1.read(buffer)) != -1) {
			ret1 += ret1;
		}
		long end = System.currentTimeMillis();

		is1.close();
		System.out.println((end - start));
	}

	 static void test2() throws FileNotFoundException, IOException {
		File f1 = new File("C:/Users/Administrator/Desktop/doc/A.txt");
		File f2 = new File("C:/Users/Administrator/Desktop/doc/B.txt");
		InputStream is1 = new FileInputStream(f1);
		InputStream is2 = new FileInputStream(f2);

		int ret1 = 0;
		String str1 = "";
		String str2 = "";
		while ((ret1 = is1.read()) != -1) {
			str1 += ret1;
		}

		while ((ret1 = is2.read()) != -1) {
			str2 += ret1;
		}
		System.out.println("s1 : " + f1.length() + " bytes: " + str1);
		System.out.println("s2 : " + f2.length() + " bytes: " + str2);
		is1.close();
		is2.close();
	}

	  static void test1() throws IOException {
		InputStream is = new FileInputStream("C:/Users/Administrator/Desktop/doc/lesson7-认识字典.docx");
		OutputStream os = new FileOutputStream("C:/Users/Administrator/Desktop/doc/lesson7-认识字典-cp.docx");
		int ret = 0;
		while ((ret = is.read()) != -1) {
			System.out.println(ret);
			os.write(ret);
		}
		is.close();
		os.close();
	}

}
