package org.solq.lesson13.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DownFileObject {
	private RandomAccessFile soure;
	private long lastAcess = System.currentTimeMillis();
	// getter

	public RandomAccessFile getSoure() {
		return soure;
	}

	public long getLastAcess() {
		return lastAcess;
	}

	public static DownFileObject of(String fileName) {
		DownFileObject ret = new DownFileObject();
		try {
			ret.soure = new RandomAccessFile(fileName, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void refresh() {
		lastAcess = System.currentTimeMillis();
	}

	public void close() {
		try {
			soure.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
