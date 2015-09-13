package imageoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedRead {
	//以字符为单位读取，读镜像时会出错
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
