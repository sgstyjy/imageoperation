package imageoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jxl.JXLException;
import jxl.Workbook;
import jxl.write.Label;    //不能import jxl.awt.Label
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;
import jxl.write.biff.JxlWriteException;
import jxl.write.biff.RowsExceededException;

public class StreamRead {
	
	private Label temp=null;

	//输入流读，以字节为单位
	public void readFile () throws IOException, JxlWriteException, JXLException{
		File file_in = new File(Constant.PATH_IN_PDF);
		InputStream reader = new FileInputStream(file_in);
		//File file_out = new File(Constant.PATH_OUT_ISO);
		
		File file_out = new File(Constant.HASHTABLE4);
		OutputStream writer = new FileOutputStream(file_out);
		//创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(writer);
		//创建表单
		WritableSheet sheet = workbook.createSheet("Hashtable",0);

		//产生数据摘要
		GenerateHashtable generater = new GenerateHashtable();	
		
		int blocknum = 0;
		int position = 0;
		int size = reader.available();
		//System.out.println(size);
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		byte[] abs = new byte[20];
		while(position<size){
		    //判断是否为最后一块
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	byte[] lastbf = new byte[(size-position)];
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	reader.read(lastbf);
		    	abs = generater.generateHashtable(lastbf);
		    	temp = new Label(blocknum/1000,blocknum%1000,abs.toString());
		    	sheet.addCell(temp);
				//writer.write(lastbf);
				break;
		    }
		    //不是最后一块就按指定块大小读取
		    reader.read(bb);
		    abs = generater.generateHashtable(bb);
		    temp = new Label(blocknum/1000,blocknum%1000,abs.toString());
		    sheet.addCell(temp);
		    position += Constant.BUFFER_SIZE;
		    blocknum++;
		}
		System.out.println("Total block: "+blocknum);
		//Number total= new Number(0,0,blocknum);
	    //sheet.addCell(total);
		workbook.write();
		workbook.close();
		reader.close();
		//writer.close();
	}
}
