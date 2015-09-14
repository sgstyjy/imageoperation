package imageoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.read.biff.BiffException;

public class CompareHash {
	
	public void compareHashtable() throws IOException, JXLException{ 
		File file_in1 = new File(Constant.HASHTABLE41);
		InputStream hashtable1 = new FileInputStream(file_in1);
		Workbook book1 = Workbook.getWorkbook(hashtable1);
		Sheet sheet1 = book1.getSheet(0);
		//int col1 = sheet1.getColumns();
		int total1 = 524287;    //hashtest1.qcow2  , 4k
		//int total = 146432;    //ubuntu2
		//System.out.println("The last line has rows: "+col1);
		//System.out.println("Table1 has total cells: "+total1);
		
		File file_in2 = new File(Constant.HASHTABLE42);
		InputStream hashtable2 = new FileInputStream(file_in2);
		Workbook book2 = Workbook.getWorkbook(hashtable2);
		Sheet sheet2 = book2.getSheet(0);
		//int col2 = sheet2.getColumns();  //column 行数， row 列
		//System.out.println("The last line has rows: "+col2);
		//int total2 = 146432;     //ubuntu2
		//int total2 = 252672;   //ubuntu1,3
		int total2 = 524287;  //hashtest2.qcow2, 4k
		//System.out.println("Table1 has total cells: "+total2);
		
		File compareresult = new File(Constant.COMPHASHTABLE_4);
		OutputStream file_out = new FileOutputStream(compareresult);		
		WritableWorkbook workbook = Workbook.createWorkbook(file_out);
		//创建表单
		WritableSheet writer = workbook.createSheet("compare_hash_result",0);
		Label temp = null;
		
		int similar = 0;
		int i=0;
		String temp1, temp2=null;
		 //对应块比较
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

		/*
		//全文比较，计算量太大
		while (i<524287){
			int j=0;
			temp1 = sheet1.getCell(i/Constant.COLUMNS,  i%Constant.COLUMNS).getContents();
			while(j<524287){
					temp2 = sheet2.getCell(j/Constant.COLUMNS,  j%Constant.COLUMNS).getContents();
					if (temp1.equals(temp2)){
								similar++;
								temp = new Label(i/Constant.COLUMNS, i%Constant.COLUMNS, "A");
								writer.addCell(temp);
					}
					j++;
			}
			i++;
		}
		*/
		workbook.write();
		workbook.close();
		double similar_ratio = (double)similar/total1;
		System.out.println("The similar blocks are :: "+similar);
		System.out.println("The similarity between these two images is: "+similar_ratio);
		hashtable1.close();
		hashtable2.close();
	}
}
