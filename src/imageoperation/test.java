package imageoperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class test {
	
	public static void main(String[] args) throws IOException, JXLException{ 
		
		//�����ļ��ͱ�
	    File file_in1 = new File(Constant.U12_4K);
		Workbook book1 = Workbook.getWorkbook(file_in1);
		Sheet sheet1bkdr = book1.getSheet(0);
		
		//��ʼ������ڵ���Ŀ
       int i = 0;
    	for (int j=0; j<Constant.PRIME;j++)
    	    	 Constant.nodenumlistbkdr[j]=0;
    	     
       //��������
      Node[] nodelist = new Node[Constant.PRIME];
     Node tempnode = new Node();
    while (i< Constant.U12_4K_TNUM){
    	              //��ȡժҪֵ
    	    	        String tempstr = sheet1bkdr.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
    	    	        long abst = Long.parseLong(tempstr);
    	    	        
    	    	      //��ժҪֵ�������е�λ��
    	    	        int position = (int) (Math.abs(abst)%Constant.PRIME);   
    	    	        
    	    	        //����Node�ڵ�
    	    	        tempnode.setBlocknum(i);
    	    	        tempnode.setHashvalue(abst);
    	    	        tempnode.next = null;
    	    	        
    	    	        if(Constant.nodenumlistbkdr[position]==0){     //�����λ�û�û��Ԫ��
    	    	        	    nodelist[position] = tempnode;         //���ýڵ���ڸ�λ��
    	    	        }
    	    	        else {                                        //�����λ���нڵ㣬���ڵ��������β��
    	    	        	     Node temp = nodelist[position];
    	    	        	     while(temp.getNext()!=null){
    	    	        	    	        temp = temp.getNext();
    	    	        	     }
    	    	        	     temp.setNext(tempnode);
    	    	        }
    	    	        Constant.nodenumlistbkdr[position]++;
    	    	        i++;
    	     }
    
             //��ӡ����
    	     int testtotal =0;
    	     for (int k = 0; k< Constant.PRIME;k++){
    	    	 
    	    	    int num = Constant.nodenumlistbkdr[k];
    	    	    Node tempn = nodelist[k];
    	    	    System.out.print(k+"  ");
    	    	    System.out.print(num+"  ");
    	    	     while(num>0){
    	    	    	       System.out.print(tempn.getHashvalue()+"  ");
    	    	    	       System.out.print(tempn.getBlocknum()+"  ");
    	    	    	       tempn = tempn.getNext();
    	    	    	       num--;
    	    	    	       testtotal++;
    	    	     }
    	    	     System.out.println();
    	     }
    	     System.out.println("�ܽڵ�����"+testtotal);
    	     System.out.println("���������");
    }
}

