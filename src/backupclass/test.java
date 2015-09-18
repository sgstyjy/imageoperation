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
		System.out.println("�����ļ��ǣ�"+file_in.getName());
		byte[] bb = new byte[Constant.BUFFER_SIZE];
		reader.read(bb);
		
		BKDRhash bkdrhasher = new BKDRhash();
		APhash aphasher = new APhash();
		
		String temp = new String(bb);
		long bkdrabs = bkdrhasher.bkdrhash(temp);     //6515873620158279550
		long apabs = aphasher.aphash(temp);
		System.out.println("BKDR����ǣ�"+bkdrabs);
		System.out.println("AP����ǣ�"+apabs);
	}
}
/*
public class test{
	public static void main(String[] args){
	
		/*
		String s = "fafafgasdfafdfafadadsagggfsfadafdaagra";
		System.out.println("Դ��Ϣ��"+s);
		
		byte[] bb = s.getBytes();
		System.out.println("Դ��Ϣ��byte��Ϣ��"+bb);
		
		//String ns = bb.toString();
		String ns = new String(s);
		System.out.println("�µ�Դ��Ϣ�ǣ�"+ns);
		
		BKDRhash bkdrhasher = new BKDRhash();
		APhash aphasher = new APhash();
		
		long bkdrabs = 0;
		long apabs = 0;
		
		bkdrabs = bkdrhasher.bkdrhash(ns);
		apabs = aphasher.aphash(ns);
		
		System.out.println("BKDR�������ǣ� "+bkdrabs);
		System.out.println("AP�������ǣ� "+apabs);
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
		System.out.println("Դ��Ϣ��"+s1);
		System.out.println("Դ��Ϣ���ȣ�"+s1.length());
		byte[] message1 = s1.getBytes();
		byte[] message2 = s2.getBytes();
		System.out.println("ת��Ϊbyte�����Ϣ��"+message1);
		System.out.println("ת��ΪString�����Ϣ��"+message1.toString());
		System.out.println("ת��Ϊbyte�󳤶ȣ�"+message1.length);
		System.out.println("ת��Ϊbyte��16���Ƶ������"+bytesToHex(message1));
		System.out.println("ת��Ϊbyte��16���Ƶĳ��ȣ�"+bytesToHex(message1).length());
		byte[] temp1, temp2 = null;
		try{
					MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
					sha1.update(message1);
					temp1 = sha1.digest(message1);
					sha1.update(message2);
					temp2 = sha1.digest(message2);
					System.out.println("��Ϣ1byte������ʽ��ժҪ�� "+temp1);
					System.out.println("��Ϣ2byte������ʽ��ժҪ�� "+temp2);
					System.out.println("��Ϣ1 16������ʽ��ժҪ�� "+bytesToHex(temp1));
					System.out.println("��Ϣ2 16������ʽ��ժҪ�� "+bytesToHex(temp2));
					System.out.println("��Ϣ2 16������ʽ��ժҪ���ȣ� "+bytesToHex(temp2).length());
					System.out.println("����ժҪ�Ƿ���ͬ�� "+temp1.equals(temp2));
					System.out.println("����ժҪ�Ƿ���ͬ�� "+bytesToHex(temp1).equals(bytesToHex(temp2)));
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
		File file_in2 = new File("hashtest1_4k (����).xls");
		Workbook book2 = Workbook.getWorkbook(file_in2);
		WritableWorkbook newbook = Workbook.createWorkbook(file_in2, book2);
		WritableSheet sheet2 = newbook.getSheet(0);
		WritableCell wc = sheet2.getWritableCell(3,8);
		wc.setString("hello world");
		return;
}
*/
