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
		
		//读入文件和表单
	    File file_in1 = new File(Constant.U12_4K);
		Workbook book1 = Workbook.getWorkbook(file_in1);
		Sheet sheet1bkdr = book1.getSheet(0);
		
		//初始化链表节点数目
       int i = 0;
    	for (int j=0; j<Constant.PRIME;j++)
    	    	 Constant.nodenumlistbkdr[j]=0;
    	     
       //产生数组
      Node[] nodelist = new Node[Constant.PRIME];
     Node tempnode = new Node();
    while (i< Constant.U12_4K_TNUM){
    	              //获取摘要值
    	    	        String tempstr = sheet1bkdr.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
    	    	        long abst = Long.parseLong(tempstr);
    	    	        
    	    	      //该摘要值在数组中的位置
    	    	        int position = (int) (Math.abs(abst)%Constant.PRIME);   
    	    	        
    	    	        //构造Node节点
    	    	        tempnode.setBlocknum(i);
    	    	        tempnode.setHashvalue(abst);
    	    	        tempnode.next = null;
    	    	        
    	    	        if(Constant.nodenumlistbkdr[position]==0){     //如果该位置还没有元素
    	    	        	    nodelist[position] = tempnode;         //将该节点放在该位置
    	    	        }
    	    	        else {                                        //如果该位置有节点，将节点放在链表尾部
    	    	        	     Node temp = nodelist[position];
    	    	        	     while(temp.getNext()!=null){
    	    	        	    	        temp = temp.getNext();
    	    	        	     }
    	    	        	     temp.setNext(tempnode);
    	    	        }
    	    	        Constant.nodenumlistbkdr[position]++;
    	    	        i++;
    	     }
    
             //打印链表
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
    	     System.out.println("总节点数："+testtotal);
    	     System.out.println("运算结束！");
    }
}

