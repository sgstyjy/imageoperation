package imageoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ResultSimilar {
	    
	 public void compareResult(String file1, String file2) throws BiffException, IOException {
		    File file_in1 = new File(file1);
	       System.out.println("The first file is: "+file_in1.getName());
	       Workbook book1 = Workbook.getWorkbook(file_in1);
			Sheet sheet1 = book1.getSheet(0);
	       
	       File file_in2 = new File(file2);
	       System.out.println("The first file is: "+file_in2.getName());
	       Workbook book2 = Workbook.getWorkbook(file_in2);
			Sheet sheet2 = book2.getSheet(0);
	       
	       int i =0;
	       int similar = 0;
	       while(i<Constant.U14WEB_4K_TNUM){
	    	        String tempstr1 = sheet1.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
	    	        String tempstr2 = sheet2.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
	    	        if ( (!tempstr1.equals("A")) && (!tempstr2.equals("A")) && tempstr1.equals(tempstr2) ) {
	    	               similar++;
	    	               i++;
	    	        }
	    	        else
	    	        	i++;
	       }
	       System.out.println("The similar blocks are: "+ similar);
	       return;
	 }
	
}
