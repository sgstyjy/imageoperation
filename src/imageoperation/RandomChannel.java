package imageoperation;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomChannel {
	//���ͨ���������ֽ�Ϊ��λ
	public void readFile() throws IOException{
		RandomAccessFile randomAccessFile = new RandomAccessFile(Constant.PATH_IN_ISO,"r");
		FileChannel reader = randomAccessFile.getChannel();
		//FileChannel writer = new RandomAccessFile(Constant.PATH_OUT_ISO,"rw").getChannel();
		ByteBuffer bb = ByteBuffer.allocate(Constant.BUFFER_SIZE);
		int position = 0;
		Long size = randomAccessFile.length();
		System.out.println(size);
		while(position<size){
		    //�ж��Ƿ�Ϊ���һ��
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	ByteBuffer lastbf = ByteBuffer.allocate((int) (size-position));
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	reader.read(lastbf,position);
				//lastbf.flip();
				//writer.write(lastbf);
				lastbf.clear();
				break;
		    }
		    //�������һ��Ͱ�ָ�����С��ȡ
		    reader.read(bb, position);
		    //bb.flip();
		    //writer.write(bb);
		    bb.clear();
		    position += Constant.BUFFER_SIZE;
		}
		reader.close();
		//writer.close();
		
	}

}
