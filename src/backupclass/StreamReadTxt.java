package backupclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import imageoperation.Constant;
import imageoperation.SHA1;
import jxl.JXLException;
import jxl.Workbook;
import jxl.write.Label;    //����import jxl.awt.Label
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;
import jxl.write.biff.JxlWriteException;
import jxl.write.biff.RowsExceededException;

public class StreamReadTxt {
	
	private Label temp=null;

	//�������������ֽ�Ϊ��λ
	public void readFile () throws IOException, JxlWriteException, JXLException{
		File file_in = new File(Constant.QCOW2_2);
		InputStream reader = new FileInputStream(file_in);
		//System.out.println("���ļ�����;");
		//File file_out = new File(Constant.PATH_OUT_ISO);
		
		File file_out = new File(Constant.Q2_4K_TXT);
		PrintStream ps = new PrintStream(new FileOutputStream(file_out));
		//OutputStream writer = new FileOutputStream(file_out);
		//�������ժҪ
		SHA1 sha1 = new SHA1();
		
		int blocknum = 0;
		int position = 0;
		int size = reader.available();
		//System.out.println(size);
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		//byte[] abs = new byte[20];
		String absresult = null;
		while(position<size){
		    //�ж��Ƿ�Ϊ���һ��
		    if((size-position)<Constant.BUFFER_SIZE)
		    {
		    	//System.out.println("This is the last block!");
		    	//System.out.println("The read position is: "+ position);
		    	byte[] lastbf = new byte[(size-position)];
		    	//System.out.println("The last buffer is: "+ lastbf.capacity());
		    	reader.read(lastbf);
		    	absresult = sha1.generateAbstract(lastbf);
	           ps.append(absresult+"\n");
				break;
		    }
		    //�������һ��Ͱ�ָ�����С��ȡ
		    reader.read(bb);
		    absresult = sha1.generateAbstract(bb);
		    ps.append(absresult+"\n");
		    position += Constant.BUFFER_SIZE;
		    blocknum++;
		}
		System.out.println("Total block: "+blocknum);
		//Number total= new Number(0,0,blocknum);
	    //sheet.addCell(total);
		//workbook.write();
		//workbook.close();
		reader.close();
		//writer.close();
	}
}
