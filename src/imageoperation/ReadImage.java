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
		//������
		//BufferedRead reader = new BufferedRead(); //���ַ�Ϊ��λ��ȡ��������ʱ�����
		//MappedRead reader = new MappedRead(); //ӳ���ڴ棬��Ubuntuʱ��5866�������ϣʱ��18383
		//RandomRead reader = new RandomRead(); //����������ֽ�Ϊ��λ����Ubuntuʱ��11478�������ϣʱ��6629
		//RandomChannel reader = new RandomChannel(); //���ͨ���������ֽ�Ϊ��λ����Ubuntuʱ��1471

		//��ȡ��ʼʱ��
		Date date = new Date();
		Long starttime = date.getTime();
		//System.out.println("The start time is: "+starttime);
		
		//������
		//StreamRead reader = new StreamRead();  //�������������ֽ�Ϊ��λ����Ubuntuʱ��801�������ϣʱ��6593
		//StreamReadTxt reader = new StreamReadTxt();
		//FastHash reader = new FastHash();
	    //reader.readFile(Constant.UBUNTU14DEVELOP,Constant.U14DEV_20K);
				
		//�Ƚ����ƶ�
		//CompareHash comHash = new CompareHash();
		//comHash.compareHashtable();
		//CompareHashtxt comHash = new CompareHashtxt();
		//comHash.compareHashtable();
	    FastCompareHash comparer = new FastCompareHash();
	  comparer.fastCompareHash(Constant.U14DEV_16K, Constant.U14DEV_16K_TNUM, Constant.U14WEB_16K, Constant.U14WEB_16K_TNUM);
		
		//��ȡ����ʱ��
		Date date1 = new Date();
		Long endtime = date1.getTime();
		//System.out.println("The end time is: "+endtime);
		Long duration = endtime-starttime;
		System.out.println("The compuate time is:"+duration);
	}
}
