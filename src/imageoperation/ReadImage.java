package imageoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReadImage {

	public void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//������
		//BufferedRead reader = new BufferedRead(); //���ַ�Ϊ��λ��ȡ��������ʱ�����
		MappedRead reader = new MappedRead(); //ӳ���ڴ�
		//RandomRead reader = new RandomRead(); //����������ֽ�Ϊ��λ
		//RandomChannel reader = new RandomChannel(); //���ͨ���������ֽ�Ϊ��λ
		//StreamRead reader = new StreamRead();  //�������������ֽ�Ϊ��λ
		
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
