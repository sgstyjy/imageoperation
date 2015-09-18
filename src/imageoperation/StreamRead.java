package imageoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jxl.JXLException;
import jxl.Workbook;
import jxl.write.Label;    //����import jxl.awt.Label
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;
import jxl.write.biff.JxlWriteException;
import jxl.write.biff.RowsExceededException;

public class StreamRead {
	
	private Label temp=null;

	//�������������ֽ�Ϊ��λ
	public void readFile () throws IOException, JxlWriteException, JXLException{
		File file_in = new File(Constant.UBUNTU12SERVER);
		InputStream reader = new FileInputStream(file_in);
		System.out.println("�����ļ��ǣ�"+file_in.getName());
		//File file_out = new File(Constant.PATH_OUT_ISO);
		
		File file_out = new File(Constant.U12_12K);
		System.out.println("����ļ��ǣ�"+file_out.getName());
		System.out.println("���С�ǣ�"+Constant.BUFFER_SIZE/1024+"K");
		OutputStream writer = new FileOutputStream(file_out);
		//����������
		WritableWorkbook workbook = Workbook.createWorkbook(writer);
		//������
		WritableSheet sheet = workbook.createSheet("Hashtable",0);

		//��������ժҪ
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
		    //�ж��Ƿ�Ϊ���һ��
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
		    //�������һ��Ͱ�ָ�����С��ȡ
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
