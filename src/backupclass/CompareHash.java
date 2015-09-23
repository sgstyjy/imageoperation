package backupclass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import imageoperation.Constant;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.read.biff.BiffException;

public class CompareHash {
	
	public void compareHashtable() throws IOException, JXLException{ 
		File file_in1 = new File(Constant.U12_4K);
		//InputStream hashtable1 = new FileInputStream(file_in1);
		//BufferedReader hashtable1 = new BufferedReader(new FileReader(Constant.U1_4K));
		Workbook book1 = Workbook.getWorkbook(file_in1);
		Sheet sheet1 = book1.getSheet(0);
		//int col1 = sheet1.getColumns();
		//int total1 = 524287;    //hashtest1.qcow2  , 4k
		//int total1 = 146432;    //ubuntu2
		//int total1 = 252672;     //ubuntu1
		int total1 = 382528;    //ubuntu12server.qcow2, 4k
		//int total1 = 191264;     //ubuntu12server.qcow2, 8k  
		//int total1 = 127509;     //ubuntu12server.qcow2, 12k 
		//int total1 = 95632;     //ubuntu12server.qcow2, 16k  
				
		//int total1 = 426320;   //ubuntu14server.qcow2, 4k 
		//int total1 = 213160;   //ubuntu14server.qcow2, 8k
		 //int total1 = 142106;   //ubuntu14server.qcow2, 12k
		//int total2 = 106580;   //ubuntu14server.qcow2, 16k
		
		File file_in2 = new File(Constant.U14WEB_4K);
		//InputStream hashtable2 = new FileInputStream(file_in2);
		Workbook book2 = Workbook.getWorkbook(file_in2);
	    Sheet sheet2 = book2.getSheet(0);
		//int total2 = 146432;     //ubuntu2
		//int total2 = 252672;   //ubuntu1,3
		//int total2 = 524287;  //hashtest2.qcow2, 4k
		
	  int total2 = 468416 ;   //ubuntu14webserver.qcow2, 4k
	     //int total2 = 234208 ;   //ubuntu14webserver.qcow2, 8k
	   //int total2 = 156138;   //ubuntu14webserver.qcow2, 12k
	   // int total2 = 117104; //ubuntu14webserver.qcow2, 16k
		
		//File compareresult = new File(Constant.COM_Q1_Q2_16K);
		//OutputStream file_out = new FileOutputStream(compareresult);		
		//WritableWorkbook workbook = Workbook.createWorkbook(file_out);
		//�����?
		//WritableSheet writer = workbook.createSheet("compare_hash_result",0);
		//Label temp = null;
		
		int similar = 0;
		int i=0;
		String temp1, temp2=null;
		
		/**
		 //��Ӧ��Ƚ�
		while(i<total1 && i<total2){
			temp1 = sheet1.getCell(i/Constant.COLUMNS,  i%Constant.COLUMNS).getContents();
			temp2 = sheet2.getCell(i/Constant.COLUMNS,  i%Constant.COLUMNS).getContents();
			if (temp1.equals(temp2)){
				similar++;
				temp = new Label(i/Constant.COLUMNS, i%Constant.COLUMNS, "A");
				writer.addCell(temp);
			}
			i++;
		}
       */
		
		//ȫ�ıȽϣ�������̫��
		while (i<total1){
			System.out.println(i);
			int j=0;
			temp1 = sheet1.getCell(i/Constant.COLUMNS,  i%Constant.COLUMNS).getContents();
			while(j<total2){
				temp2 = sheet2.getCell(j/Constant.COLUMNS,  j%Constant.COLUMNS).getContents();
					if (temp1.equals(temp2)){
								similar++;
								//temp = new Label(i/Constant.COLUMNS, i%Constant.COLUMNS, "A");
								//writer.addCell(temp);
								//Label reset = new Label(j/Constant.COLUMNS,  j%Constant.COLUMNS,null);
								//sheet2.addCell(reset);
								break;
					}
					j++;
			}
			i++;
		}
		//workbook.write();
		//workbook.close();
		double similar_ratio = (double)similar/total2;
		System.out.println("The first input file is:  "+file_in1.getName());
		System.out.println("The second input file is:  "+file_in2.getName());
		System.out.println("The similar blocks are : "+similar);
		System.out.println("The similarity between these two images is: "+similar_ratio);
		//hashtable1.close();
		//hashtable2.close();
	}
}
