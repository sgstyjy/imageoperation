package imageoperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.read.biff.BiffException;

public class CompareHashtxt {
	
	public void compareHashtable() throws IOException, JXLException{ 
		//FileReader file_in1 = new FileReader(Constant.Q1_4K_TXT);
		//BufferedReader reader1 = new BufferedReader(file_in1);
		RandomAccessFile reader1 = new RandomAccessFile(Constant.Q1_4K,"r");
		int total1 = 524287;    //hashtest1.qcow2  , 4k
		//int total1 = 146432;    //ubuntu2
		//int total1 = 252672;     //ubuntu1
		//System.out.println("The last line has rows: "+col1);
		//System.out.println("Table1 has total cells: "+total1);
		
		//FileReader file_in2 = new FileReader(Constant.Q2_4K_TXT);
		//BufferedReader reader2 = new BufferedReader(file_in2);
		RandomAccessFile reader2 = new RandomAccessFile(Constant.Q2_4K,"r");
		//int total2 = 146432;     //ubuntu2
		//int total2 = 252672;   //ubuntu1,3
		//int total2 = 524287;  //hashtest2.qcow2, 4k
		
		File compareresult = new File(Constant.COM_Q1_Q2_4K);
		OutputStream file_out = new FileOutputStream(compareresult);		
		WritableWorkbook workbook = Workbook.createWorkbook(file_out);
		//创建表单
		WritableSheet writer = workbook.createSheet("compare_hash_result",0);
		Label temp = null;
		
		int similar = 0;
		int i=0;
		String temp1, temp2=null;
		
		/*
		 //对应块比较
		while((temp1 = reader1.readLine())!=null && (temp2 = reader2.readLine())!=null){
			if (temp1.equals(temp2)){
				similar++;
				temp = new Label(i/Constant.COLUMNS, i%Constant.COLUMNS, "A");
				writer.addCell(temp);
			}
		}
       */
		//全文比较，计算量太大
		while ((temp1 = reader1.readLine())!=null){
			System.out.println(i);
			reader2.seek(0);
			while((temp2 = reader2.readLine())!=null){
					if (temp1.equals(temp2)){
								similar++;
								temp = new Label(i/Constant.COLUMNS, i%Constant.COLUMNS, "A");
								writer.addCell(temp);
								break;
					}
			}
			i++;
		}
		
		workbook.write();
		workbook.close();
		double similar_ratio = (double)similar/total1;
		System.out.println("The similar blocks are : "+similar);
		System.out.println("The similarity between these two images is: "+similar_ratio);
		reader1.close();
		reader2.close();
		//hashtable1.close();
		//hashtable2.close();
	}
}
