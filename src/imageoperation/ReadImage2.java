package imageoperation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class ReadImage2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Date date = new Date();
		Long starttime = date.getTime();
		System.out.println(starttime);
		
		randomReadFile();
		
		Date date1 = new Date();
		Long endtime = date1.getTime();
		System.out.println(endtime);
		Long duration = endtime-starttime;
		System.out.println(duration);
	}
	
	public static void randomReadFile() throws IOException{
		RandomAccessFile read = new RandomAccessFile("D://Eclipse-workspace/imageoperation/test.pdf","r");
		RandomAccessFile writer = new RandomAccessFile("D://Eclipse-workspace/imageoperation/result.temp","rw");
		byte[] b = new byte[4*1024];
		while(read.read(b)!=-1){
			writer.write(b);
		}
		writer.close();
		read.close();
	}


}
