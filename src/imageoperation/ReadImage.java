package imageoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReadImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//������
		//BufferedRead reader = new BufferedRead(); //���ַ�Ϊ��λ��ȡ��������ʱ�����
		//MappedRead reader = new MappedRead(); //ӳ���ڴ棬��Ubuntuʱ��5866�������ϣʱ��18383
		//RandomRead reader = new RandomRead(); //����������ֽ�Ϊ��λ����Ubuntuʱ��11478�������ϣʱ��6629
		//RandomChannel reader = new RandomChannel(); //���ͨ���������ֽ�Ϊ��λ����Ubuntuʱ��1471
		StreamRead reader = new StreamRead();  //�������������ֽ�Ϊ��λ����Ubuntuʱ��801�������ϣʱ��6593
		
		//��ȡ��ʼʱ��
		Date date = new Date();
		Long starttime = date.getTime();
		System.out.println(starttime);
		
		//������
		reader.readFile();
		
		//��ȡ����ʱ��
		Date date1 = new Date();
		Long endtime = date1.getTime();
		System.out.println(endtime);
		Long duration = endtime-starttime;
		System.out.println(duration);
	}



}
