package imageoperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomChannel {
	//随机通道读，以字节为单位
	public void readFile() throws IOException{
		RandomAccessFile randomAccessFile = new RandomAccessFile(Constant.PATH_IN_ISO1,"r");
		FileChannel reader = randomAccessFile.getChannel();
		//FileChannel writer = new RandomAccessFile(Constant.PATH_OUT_ISO,"rw").getChannel();
		File hashtable = new File(Constant.HASHTABLE1);
		OutputStream writer = new FileOutputStream(hashtable);
		GenerateHashtable generater = new GenerateHashtable();
		
		ByteBuffer bb = ByteBuffer.allocate(Constant.BUFFER_SIZE);
		int position = 0;
		Long size = randomAccessFile.length();
		System.out.println(size);
		while(position<size){
		    //判断是否为最后一块
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	int lastlenght = (int)(size-position);
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	ByteBuffer lastbf = ByteBuffer.allocate(lastlenght);
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	reader.read(lastbf,position);
		    	byte[] dst = new byte[lastlenght];
		    	lastbf.get(dst);
		    	generater.generateHashtable(dst);
				//lastbf.flip();
				//writer.write(lastbf);
				lastbf.clear();
				break;
		    }
		    //不是最后一块就按指定块大小读取
		    reader.read(bb, position);
		    byte[] dst = new byte[Constant.BUFFER_SIZE];
		    bb.get(dst);
		    generater.generateHashtable(dst);
		    //bb.flip();
		    //writer.write(bb);
		    bb.clear();
		    position += Constant.BUFFER_SIZE;
		}
		reader.close();
		//writer.close();
		
	}

}
