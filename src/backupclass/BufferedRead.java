package backupclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedRead {
	//锟斤拷锟街凤拷为锟斤拷位锟斤拷取锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟�
	public void readFile() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(Constant.PATH_IN_ISO1));
		//PrintWriter pw = new PrintWriter(Constant.PATH_OUT_ISO);
		char[] c = new char[Constant.BUFFER_SIZE];
		for(;;){
			if(br.read(c)!=-1){
				//pw.print(c);
			}else{
				break;
			}
		}
		//pw.close();
		br.close();
	}
}
