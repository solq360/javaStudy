package org.solq.lesson13.demo;

public interface ISyncService {
	public String[] compareFile(String inputDir, String outDir);
	public void sync(String target,String... file);
}
