package imageoperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ReadImage3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Date date = new Date();
		Long starttime = date.getTime();
		System.out.println(starttime);
		
		mappedBuffer();
		
		Date date1 = new Date();
		Long endtime = date1.getTime();
		System.out.println(endtime);
		Long duration = endtime-starttime;
		System.out.println(duration);
	}
	public static void mappedBuffer() throws IOException{
		FileChannel read = new FileInputStream("D://Eclipse-workspace/imageoperation/test.pdf").getChannel();
		FileChannel writer = new RandomAccessFile("D://Eclipse-workspace/imageoperation/result.pdf","rw").getChannel();
		long i = 0;
		long size = 4*1024;
		System.out.println(read.size());
		System.out.println(size);
		ByteBuffer bb,cc = null;
		while(i<read.size()&&(read.size()-i)>size){
			bb = read.map(FileChannel.MapMode.READ_ONLY, i, size);
			cc = writer.map(FileChannel.MapMode.READ_WRITE, i, size);
			//System.out.println(i);
			cc.put(bb);
			i+=size;
			bb.clear();
			cc.clear();
		}
		System.out.println(i);
		System.out.println("This is the last size:");
		System.out.println(read.size()-i);
		bb = read.map(FileChannel.MapMode.READ_ONLY, i, read.size()-i);
		cc = writer.map(FileChannel.MapMode.READ_WRITE, i, read.size()-i);
		cc.put(bb);
		bb.clear();
		cc.clear();
		read.close();
		writer.close();
	}

}
