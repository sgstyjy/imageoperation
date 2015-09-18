package backupclass;

import imageoperation.BKDRhash;
import imageoperation.Constant;
import imageoperation.APhash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class test{
	public static void main(String[] args) throws IOException{
		File file_in = new File("test.txt");      //Constant.UBUNTU12SERVER);
		InputStream reader = new FileInputStream(file_in);
		System.out.println("输入文件是："+file_in.getName());
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		reader.read(bb);
		
		BKDRhash bkdrhasher = new BKDRhash();
		APhash aphasher = new APhash();
		
		String temp = new String(bb);
		long bkdrabs = bkdrhasher.bkdrhash(temp);     //6515873620158279550
		long apabs = aphasher.aphash(temp);
		System.out.println("BKDR输出是："+bkdrabs);
		System.out.println("AP输出是："+apabs);
	}
}
/*
public class test{
	public static void main(String[] args){
	
		/*
		String s = "fafafgasdfafdfafadadsagggfsfadafdaagra";
		System.out.println("源消息："+s);
		
		byte[] bb = s.getBytes();
		System.out.println("源消息的byte信息："+bb);
		
		//String ns = bb.toString();
		String ns = new String(s);
		System.out.println("新的源消息是："+ns);
		
		BKDRhash bkdrhasher = new BKDRhash();
		APhash aphasher = new APhash();
		
		long bkdrabs = 0;
		long apabs = 0;
		
		bkdrabs = bkdrhasher.bkdrhash(ns);
		apabs = aphasher.aphash(ns);
		
		System.out.println("BKDR输出结果是： "+bkdrabs);
		System.out.println("AP输出结果是： "+apabs);
		return;
	}
}
*/
/*
public class test {

	 public static void main(String[] args) throws Exception {
	    //public String generateAbstract(byte [] message) {
		// TODO Auto-generated method stub
		String s1 = "sdvsgsgsgrr";
		String s2 = "sdv";
		System.out.println("源消息："+s1);
		System.out.println("源消息长度："+s1.length());
		byte[] message1 = s1.getBytes();
		byte[] message2 = s2.getBytes();
		System.out.println("转换为byte后的消息："+message1);
		System.out.println("转换为String后的消息："+message1.toString());
		System.out.println("转换为byte后长度："+message1.length);
		System.out.println("转换为byte后16进制的输出："+bytesToHex(message1));
		System.out.println("转换为byte后16进制的长度："+bytesToHex(message1).length());
		byte[] temp1, temp2 = null;
		try{
					MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
					sha1.update(message1);
					temp1 = sha1.digest(message1);
					sha1.update(message2);
					temp2 = sha1.digest(message2);
					System.out.println("消息1byte进制形式的摘要： "+temp1);
					System.out.println("消息2byte进制形式的摘要： "+temp2);
					System.out.println("消息1 16进制形式的摘要： "+bytesToHex(temp1));
					System.out.println("消息2 16进制形式的摘要： "+bytesToHex(temp2));
					System.out.println("消息2 16进制形式的摘要长度： "+bytesToHex(temp2).length());
					System.out.println("两个摘要是否相同： "+temp1.equals(temp2));
					System.out.println("两个摘要是否相同： "+bytesToHex(temp1).equals(bytesToHex(temp2)));
		}catch(Exception e){
			System.out.println("Exception: "+e);
		}
		return;
	}
	   public static String bytesToHex(byte[] b) {
		      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
		                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		      StringBuffer buf = new StringBuffer();
		      //System.out.println(b.length);
		      for (int j=0; j<b.length; j++) {
		         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
		         //buf.append(hexDigit[b[j] & 0x0f]);
		      }
		      return buf.toString();
		   }

}
*/
/*
import java.io.File;
import java.io.IOException;

import imageoperation.Constant;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableWorkbook;

public static void main (String[] args) {
		File file_in2 = new File("hashtest1_4k (复件).xls");
		Workbook book2 = Workbook.getWorkbook(file_in2);
		WritableWorkbook newbook = Workbook.createWorkbook(file_in2, book2);
		WritableSheet sheet2 = newbook.getSheet(0);
		WritableCell wc = sheet2.getWritableCell(3,8);
		wc.setString("hello world");
		return;
}
*/
