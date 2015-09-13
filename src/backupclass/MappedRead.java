package backupclass;

import imageoperation.Constant;
import imageoperation.GenerateHashtable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedRead {
	//映射内存
	public void readFile () throws IOException{
		FileChannel reader = new FileInputStream(Constant.PATH_IN_ISO1).getChannel();
		//FileChannel writer = new RandomAccessFile(Constant.PATH_OUT_ISO,"rw").getChannel();
		File hashtable = new File(Constant.HASHTABLE1);
		OutputStream writer = new FileOutputStream(hashtable);
		GenerateHashtable generater = new GenerateHashtable();
		
		int position = 0;
		Long size = reader.size();
		ByteBuffer bb= null;
		//ByteBuffer cc =null;
		while(position<size){
		    //判断是否为最后一块
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	int lastlenght = (int)(size-position);
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	bb = reader.map(FileChannel.MapMode.READ_ONLY, position, lastlenght);
		    	byte[] dst = new byte[lastlenght];
		    	bb.get(dst);
		    	generater.generateHashtable(writer, dst);
		    	//cc = writer.map(FileChannel.MapMode.READ_WRITE, position, lastlenght);
		    	//cc.put(bb);
		    	bb.clear();
				//cc.clear();
				break;
		    }
		    bb = reader.map(FileChannel.MapMode.READ_ONLY, position, Constant.BUFFER_SIZE);
		    byte[] dst = new byte[Constant.BUFFER_SIZE];
		    bb.get(dst);
		    generater.generateHashtable(writer, dst);
			//cc = writer.map(FileChannel.MapMode.READ_WRITE, position, Constant.BUFFER_SIZE);
			//cc.put(bb);
			position += Constant.BUFFER_SIZE;
			bb.clear();
			//cc.clear();
		}
		reader.close();
		//writer.close();	
	}
}
