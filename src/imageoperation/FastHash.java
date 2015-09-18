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

public class FastHash {
	
		//输入流读，以字节为单位
	public void readFile (String pathin,String pathout) throws IOException, JXLException{
		File file_in = new File(pathin);      //Constant.UBUNTU12SERVER);
		InputStream reader = new FileInputStream(file_in);
		System.out.println("输入文件是："+file_in.getName());
		//File file_out = new File(Constant.PATH_OUT_ISO);
		
		File file_out1 = new File(pathout);      //Constant.U12_4K);
		System.out.println("BKDR输出文件是："+file_out1.getName());
		System.out.println("块大小是："+Constant.BUFFER_SIZE/1024+"K");
		OutputStream writer1 = new FileOutputStream(file_out1);
		//创建工作薄
		WritableWorkbook workbook1 = Workbook.createWorkbook(writer1);
		//创建表单
		WritableSheet sheet1 = workbook1.createSheet("BKDRHashtable",0);
		WritableSheet sheet2 = workbook1.createSheet("APHashtable",1);

		//产生数据摘要
		BKDRhash bkdrhasher = new BKDRhash();
		APhash aphasher = new APhash();
		
		int blocknum = 0;
		int position = 0;
		int size = reader.available();
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		String temp = null;
		long bkdrabs = 0;
		long apabs = 0;
		while(position<size){
					//判断是否为最后一块
					if((size-position)<Constant.BUFFER_SIZE){
								byte[] lastbf = new byte[(size-position)];
								reader.read(lastbf);
								temp = new String(lastbf);
								bkdrabs = bkdrhasher.bkdrhash(temp);
								apabs = aphasher.aphash(temp);	    	
								String temp1 = Long.toString(bkdrabs);
								String temp2 = Long.toString(apabs);
								Label tempcell1 = new Label (blocknum/Constant.COLUMNS,blocknum%Constant.COLUMNS, temp1);
								Label tempcell2 = new Label (blocknum/Constant.COLUMNS,blocknum%Constant.COLUMNS, temp2);
								sheet1.addCell(tempcell1);
								sheet2.addCell(tempcell2);
								break;
					}
					//不是最后一块就按指定块大小读取
					reader.read(bb);
					temp = new String (bb);
					bkdrabs = bkdrhasher.bkdrhash(temp);
					apabs = aphasher.aphash(temp);	    	
					String temp1 = Long.toString(bkdrabs);
					String temp2 = Long.toString(apabs);
					Label tempcell1 = new Label (blocknum/Constant.COLUMNS,blocknum%Constant.COLUMNS, temp1);
					Label tempcell2 = new Label (blocknum/Constant.COLUMNS,blocknum%Constant.COLUMNS, temp2);
					sheet1.addCell(tempcell1);
					sheet2.addCell(tempcell2);
					position += Constant.BUFFER_SIZE;
					blocknum++;
		}
		System.out.println("Total block: "+blocknum);
		workbook1.write();
		workbook1.close();
		reader.close();
	}
}

