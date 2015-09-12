package imageoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamRead {
	//输入流读，以字节为单位
	public void readFile () throws IOException{
		File file_in = new File(Constant.PATH_IN_ISO);
		//File file_out = new File(Constant.PATH_OUT_ISO);
		InputStream reader = new FileInputStream(file_in);
		//OutputStream writer = new FileOutputStream(file_out);
		int position = 0;
		int size = reader.available();
		//System.out.println(size);
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		while(position<size){
		    //判断是否为最后一块
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	byte[] lastbf = new byte[(size-position)];
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	reader.read(lastbf);
				//writer.write(lastbf);
				break;
		    }
		    //不是最后一块就按指定块大小读取
		    reader.read(bb);
		    //writer.write(bb);
		    position += Constant.BUFFER_SIZE;
		}
		reader.close();
		//writer.close();
	}
}
