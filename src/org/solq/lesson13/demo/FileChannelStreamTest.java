package org.solq.lesson13.demo;

public class FileChannelStreamTest {

	public static void main(String[] args) {
		FileChannelStream fcs = new FileChannelStream("C:/Users/Administrator/Desktop/Â¼Ïñ/test.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/Â¼Ïñ/test1.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/Â¼Ïñ/test2.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/Â¼Ïñ/test3.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/Â¼Ïñ/test4.txt");
		fcs.pipe("C:/Users/Administrator/Desktop/Â¼Ïñ/test5.txt");
		fcs.sync();
		fcs.close();
	}
}
