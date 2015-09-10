package imageoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReadImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//oldIO
		Date date = new Date();
		Long starttime = date.getTime();
		System.out.println(starttime);
		oldIOReadFile();
		Date date1 = new Date();
		Long endtime = date1.getTime();
		System.out.println(endtime);
		Long duration = endtime-starttime;
		System.out.println(duration);

	}
	public static void oldIOReadFile() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("D://Eclipse-workspace/imageoperation/test.pdf"));
		PrintWriter pw = new PrintWriter("D://Eclipse-workspace/imageoperation/result.pdf");
		char[] c = new char[4*1024];
		for(;;){
			if(br.read(c)!=-1){
				pw.print(c);
			}else{
				break;
			}
		}
		pw.close();
		br.close();
	}


}
