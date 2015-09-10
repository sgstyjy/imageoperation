package imageoperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class GenerateHashtable {

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
		byte[] abs=null;
		SHA1 sha1 = new SHA1();		
		FileChannel read = new FileInputStream("D://Eclipse-workspace/imageoperation/test.pdf").getChannel();
		PrintWriter pw = new PrintWriter("D://Eclipse-workspace/imageoperation/hashtable.txt");
		long i = 0;
		int block_num=0;
		Long file_size=read.size();
		System.out.println(file_size);
		System.out.println(Constant.BUFFER_SIZE);
		ByteBuffer bb = null;
		String temp = null;
		//read.size()返回的始终是整个文件的大小
		while(i<file_size&&(file_size-i)>Constant.BUFFER_SIZE){
			bb = read.map(FileChannel.MapMode.READ_ONLY, i, Constant.BUFFER_SIZE);
			temp = bb.toString();
			abs = sha1.sha1Digest(temp);
			pw.println(block_num+" "+abs.toString());
			i+=Constant.BUFFER_SIZE;
			block_num++;
			bb.clear();
		}
		System.out.println(i);
		System.out.println("This is the last size:");
		System.out.println(file_size-i);
		bb = read.map(FileChannel.MapMode.READ_ONLY, i, file_size-i);
		temp = bb.toString();
		abs = sha1.sha1Digest(temp);
		pw.print(block_num+" "+abs.toString());
		bb.clear();
		read.close();
		pw.close();
	}
}

