package imageoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jxl.JXLException;
import jxl.write.biff.JxlWriteException;

public class ReadImage {

	public static void main(String[] args) throws IOException, JxlWriteException, JXLException {
		// TODO Auto-generated method stub
		//读镜像
		//BufferedRead reader = new BufferedRead(); //以字符为单位读取，读镜像时会出错
		//MappedRead reader = new MappedRead(); //映射内存，读Ubuntu时间5866，计算哈希时间18383
		//RandomRead reader = new RandomRead(); //随机读，以字节为单位，读Ubuntu时间11478，计算哈希时间6629
		//RandomChannel reader = new RandomChannel(); //随机通道读，以字节为单位，读Ubuntu时间1471

		//读取开始时间
		Date date = new Date();
		Long starttime = date.getTime();
		//System.out.println("The start time is: "+starttime);
		
		//读镜像
		StreamRead reader = new StreamRead();  //输入流读，以字节为单位，读Ubuntu时间801，计算哈希时间6593
		//StreamReadTxt reader = new StreamReadTxt();
		reader.readFile();
		
		//比较相似度
		//CompareHash comHash = new CompareHash();
		//comHash.compareHashtable();
		
		//比较相似度
		//CompareHashtxt comHash = new CompareHashtxt();
		//comHash.compareHashtable();
		
		//读取结束时间
		Date date1 = new Date();
		Long endtime = date1.getTime();
		//System.out.println("The end time is: "+endtime);
		Long duration = endtime-starttime;
		System.out.println("The compuate time is:"+duration);
	}
}
