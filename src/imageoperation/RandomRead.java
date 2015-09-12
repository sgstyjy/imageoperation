package imageoperation;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomRead {
	//����������ֽ�Ϊ��λ
	public void readFile() throws IOException{
		RandomAccessFile reader = new RandomAccessFile(Constant.PATH_IN_ISO,"r");
		//RandomAccessFile writer = new RandomAccessFile(Constant.PATH_OUT_ISO,"rw");
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		int position = 0;
		Long size = reader.length();
		System.out.println(size);
		while(position<size){
		    //�ж��Ƿ�Ϊ���һ��
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	int lastlenght = (int)(size-position);
		    	//System.out.println("This is the last block: "+lastlenght);
		    	//System.out.println("The read position is: "+ position);
		    	byte[] lastbf = new byte[lastlenght];
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	int i = reader.read(lastbf);
		    	//System.out.println(writer.getFilePointer());
		    	//writer.write(lastbf);
		    	//System.out.println(writer.getFilePointer());
		    	//System.out.println(i);
				break;
		    }
		    //�������һ��Ͱ�ָ�����С��ȡ
		    //System.out.println("�����ȡ");
		    reader.read(bb);
	    	//writer.write(bb);
		    position += Constant.BUFFER_SIZE;
		}
		//writer.close();
		reader.close();
	}
}
