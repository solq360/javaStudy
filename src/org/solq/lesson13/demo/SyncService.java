package org.solq.lesson13.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SyncService implements ISyncService {

	private final boolean debugFlag = true;

	private int sleep = 5000;

	private String inputDir;

	private String outDir;

	// <文件名，最后修改时间>
	private Map<String, Long> cacheLastModified = new HashMap<>();

	private final Thread thread = new Thread(new Runnable() {

		@Override
		public void run() {

			while (!Thread.interrupted()) {
				// 输入参数为，监听的文件目录，要监听输出结果目录
				// 返回要同步的文件列表
				String[] syncFiles = compareFile(inputDir, outDir);
				if (syncFiles.length > 0) {
					sync(outDir, syncFiles);
				}
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}, "监控文件线程");

	public SyncService(String inputDir, String outDir) {

		this.outDir = outDir;
		this.inputDir = inputDir;
	}

	public static void main(String[] args) throws InterruptedException {
		new SyncService("c:/TEST", "c:/a").start();
		new SyncService("c:/a", "c:/TEST").start();
		while(true){
			Thread.sleep(800);
		}
	}

	public void start() {
		init();
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public String[] compareFile(String inputDir, String outDir) {
		Set<String> ret = new HashSet<>();

		File inputFile = new File(inputDir);

		Set<File> tmpFile = new HashSet<>();
		scanFile(tmpFile, inputFile);

		for (File tf : tmpFile) {
			Long lastTime = cacheLastModified.get(tf.getAbsolutePath());
			// 首次生成或者有文件修改过，那么保存返回文件名
			if (lastTime == null || tf.lastModified() > lastTime) {
				lastTime = tf.lastModified();
				ret.add(tf.getAbsolutePath());
				// 这里的逻辑应该等同步完之后再记录最后修改时间
				cacheLastModified.put(tf.getAbsolutePath(), lastTime);
				if (debugFlag) {
					System.out.println("同步文件名  : " + tf.getAbsolutePath() );
				}
			}
		}

		return ret.toArray(new String[0]);
	}

	@Override
	public void sync(String target, String... files) {
		String inputDirName = new File(inputDir).getAbsolutePath();
		for (String file : files) {
			cpFile(file, target + file.replace(inputDirName, ""));
			if (debugFlag) {
				System.out.println("同步文件中  : " + file);
			}
		}
	}

	static void cpFile(String inputFileName, String outputFileName) {
		InputStream is = null;
		OutputStream os = null;
		File checkOutDir = new File(outputFileName);
		if(!checkOutDir.exists()){
			checkOutDir.getParentFile().mkdirs();
			
		}
		try {
			is = new BufferedInputStream(new FileInputStream(inputFileName));
			os = new BufferedOutputStream(new FileOutputStream(outputFileName));
			// 流来的，所以要循环读取
			// 每次去硬盘读是很慢的，所以用内存去换操作次数
			byte[] buf = new byte[1 << 16];
			while (is.read(buf) != -1) {
				os.write(buf);
			}
		} catch (Exception e) {
		} finally {
			try {
				is.close();

				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void scanFile(Set<File> ret, File inputFile) {
		if (!inputFile.isDirectory()) {
			// 文件名的话直接添加进去
			ret.add(inputFile);
		} else {
			// 文件夹递归调用处理逻辑
			File[] childFile = inputFile.listFiles();
			for (File cf : childFile) {
				scanFile(ret, cf);
			}
		}
	}

	private void init() {
		File outFile = new File(outDir);

		Set<File> tmpFile = new HashSet<>();
		scanFile(tmpFile, outFile);

		for (File tf : tmpFile) {
			cacheLastModified.put(tf.getAbsolutePath(), tf.lastModified());
			if (debugFlag) {
				System.out.println("初始化文件名  : " + tf.getAbsolutePath());
			}
		}
	}
}
