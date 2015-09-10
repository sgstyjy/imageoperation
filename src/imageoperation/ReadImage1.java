package imageoperation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ReadImage1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Date date = new Date();
		Long starttime = date.getTime();
		System.out.println(starttime);
		
		newIOReadFile();
		
		Date date1 = new Date();
		Long endtime = date1.getTime();
		System.out.println(endtime);
		Long duration = endtime-starttime;
		System.out.println(duration);
	}
	
	public static void newIOReadFile() throws IOException{
		RandomAccessFile randomAccessFile = new RandomAccessFile("D://Eclipse-workspace/imageoperation/test.pdf","r");
		FileChannel read = randomAccessFile.getChannel();
		FileChannel writer = new RandomAccessFile("D://Eclipse-workspace/imageoperation/result.temp","rw").getChannel();
		int bufferLength = 4*1024;
		ByteBuffer bb = ByteBuffer.allocate(bufferLength);
		int position = 0;
		Long size = randomAccessFile.length();
		while((position<size) && (size-position)>bufferLength){
		//while(read.read(bb)!=-1){
			read.read(bb, position);
			bb.flip();
			writer.write(bb);
			bb.clear();
			position += bufferLength;
		}
	    if((size-position)<bufferLength)
	    {
	    	ByteBuffer lastbf = ByteBuffer.allocate((int) (size-position));
	    	read.read(lastbf);
			bb.flip();
			writer.write(lastbf);
			lastbf.clear();
	    }
	    	
		read.close();
		writer.close();
		
	}


}
