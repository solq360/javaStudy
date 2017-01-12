package org.solq.lesson13.demo;

public interface IFileChannel {
	public void pipe(String...files);
	//public void pipe(IFileChannel...channels);
	
	public void sync();
	
	public void close();
}
