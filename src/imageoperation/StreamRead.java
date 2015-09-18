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
		File file_in = new File(Constant.UBUNTU12SERVER);
		InputStream reader = new FileInputStream(file_in);
		System.out.println("输入文件是："+file_in.getName());
		//File file_out = new File(Constant.PATH_OUT_ISO);
		
		File file_out = new File(Constant.U12_12K);
		System.out.println("输出文件是："+file_out.getName());
		System.out.println("块大小是："+Constant.BUFFER_SIZE/1024+"K");
		OutputStream writer = new FileOutputStream(file_out);
		//创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(writer);
		//创建表单
		WritableSheet sheet = workbook.createSheet("Hashtable",0);

		//产生数据摘要
		//GenerateHashtable generater = new GenerateHashtable();
		SHA1 sha1 = new SHA1();
		
		int blocknum = 0;
		int position = 0;
		int size = reader.available();
		//System.out.println(size);
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		//byte[] abs = new byte[20];
		String absresult = null;
		while(position<size){
		    //判断是否为最后一块
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	byte[] lastbf = new byte[(size-position)];
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	reader.read(lastbf);
		    	absresult = sha1.generateAbstract(lastbf);
		    	temp = new Label(blocknum/Constant.COLUMNS,blocknum%Constant.COLUMNS,absresult);
		    	sheet.addCell(temp);
				break;
		    }
		    //不是最后一块就按指定块大小读取
		    reader.read(bb);
		    absresult = sha1.generateAbstract(bb);
		    temp = new Label(blocknum/Constant.COLUMNS,blocknum%Constant.COLUMNS,absresult);
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
