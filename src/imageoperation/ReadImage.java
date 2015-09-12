package imageoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReadImage {

	public void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//读镜像
		//BufferedRead reader = new BufferedRead(); //以字符为单位读取，读镜像时会出错
		MappedRead reader = new MappedRead(); //映射内存
		//RandomRead reader = new RandomRead(); //随机读，以字节为单位
		//RandomChannel reader = new RandomChannel(); //随机通道读，以字节为单位
		//StreamRead reader = new StreamRead();  //输入流读，以字节为单位
		
		//读取开始时间
		Date date = new Date();
		Long starttime = date.getTime();
		System.out.println(starttime);
		
		//读镜像
		reader.readFile();
		
		//读取结束时间
		Date date1 = new Date();
		Long endtime = date1.getTime();
		System.out.println(endtime);
		Long duration = endtime-starttime;
		System.out.println(duration);
	}



}
