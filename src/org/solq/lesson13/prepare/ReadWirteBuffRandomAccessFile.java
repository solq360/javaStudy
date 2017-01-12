package org.solq.lesson13.prepare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadWirteBuffRandomAccessFile extends RandomAccessFile{

	private int readPos =0;
	private int readStartPos =0;
	private int readEndPos =0;
	private byte[] readBuff;
	
	
	private int writePos =0;
	private int writeStartPos =0;
	private int writeEndPos =0;
	private byte[] writeBuff;
	
	private static final int defaultReadBuffLeng=1<<4;
	private static final int defaultWriteBuffLeng=1<<4;
	
	private void init(int readLeng,int writeLeng){
		readBuff=new byte[readLeng];
		writeBuff=new byte[writeLeng];
	}
	
	public ReadWirteBuffRandomAccessFile(File file, String mode) throws FileNotFoundException {
		super(file, mode);
		init(defaultReadBuffLeng, defaultWriteBuffLeng);
 	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		
		int ret =0;
		long limin = this.readPos+len;
		if(limin< this.readEndPos){
			System.arraycopy(this.readBuff, this.readStartPos, b, off, len);
			ret =len;
 		}
		this.readPos+=ret;
		return ret;
	}
	
	private void fushReadBuf(int pos){
		int ret = 0;
		try {
			ret=super.read(readBuff,0,defaultReadBuffLeng);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
