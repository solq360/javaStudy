package org.solq.lesson13.demo;

public class FileChannelStreamTest {

	public static void main(String[] args) {
		FileChannelStream fcs = new FileChannelStream("C:/Users/Administrator/Desktop/¼��/test.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/¼��/test1.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/¼��/test2.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/¼��/test3.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/¼��/test4.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/¼��/test5.txt");
		fcs.sync();
		fcs.close();
	}
}
