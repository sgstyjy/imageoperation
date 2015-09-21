package imageoperation;

import java.io.File;
import java.io.IOException;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FastCompareHash {
	
	   private Node temp;

	public void fastCompareHash(String path1 , int total1, String path2,  int total2) throws BiffException, IOException{
		   //read the first file, and then the two hashtables
		    File file_in1 = new File(path1);
		    System.out.println("输入文件1是："+file_in1.getName());
			Workbook book1 = Workbook.getWorkbook(file_in1);
			Sheet sheet1bkdr = book1.getSheet(0);
			Sheet sheet1ap = book1.getSheet(1);
			Node[] bkdr1 = new Node[Constant.PRIME]; 
			Node[] ap1 = new Node[Constant.PRIME]; 
			
			//generate array according to the hashtables
			bkdr1 = generateArray(sheet1bkdr, Constant.nodenumlistbkdr, total1);
			ap1 = generateArray(sheet1ap, Constant.nodenumlistap, total1);
			
			File file_in2 = new File(path2);
			System.out.println("输入文件2是："+file_in2.getName());
			Workbook book2 = Workbook.getWorkbook(file_in2);
			Sheet sheet2bkdr = book2.getSheet(0);
			Sheet sheet2ap = book2.getSheet(1);
			
			int i =0;
			String temps1, temps2=null;
			long templ1,templ2 = 0;
			while(i< total2){
				       //read data from the second file
				       //System.out.println(i);
						temps1 = sheet2bkdr.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
						temps2 = sheet2ap.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
						templ1 = Long.parseLong(temps1);
						templ2 = Long.parseLong(temps2);
						//if the both hash values are same, then the data block is same
						if(findHash(bkdr1, Constant.nodenumlistbkdr, templ1) && findHash(ap1, Constant.nodenumlistap,templ2))
						{
							    Constant.similar++;
							    i++;
							    //break;
						}
						else {
							i++;      
						}
			}
			System.out.println("The original block amount is: "+total2);
			System.out.println("The compare block amount is: "+i);
			double similarity = (double) Constant.similar / total2; 
			System.out.println("相似块数："+Constant.similar);
			System.out.println("相似度："+similarity);
			return;
	   }
        
	   //generate array according to hashtable
	    public Node[]  generateArray(Sheet sheet, int[] nodenumlist, int  totalnum){
	    	     int i = 0;
	    	     //initialize the nodenumlist[]
	    	      for (int j=0; j<Constant.PRIME;j++)
	    	    	      nodenumlist[j]=0;
	    	     
	    	     Node[] nodelist = new Node[Constant.PRIME];
	    	     while (i< totalnum){
	    	    	        String tempstr = sheet.getCell(i/Constant.COLUMNS, i%Constant.COLUMNS).getContents();
	    	    	        long abst = Long.parseLong(tempstr);
	    	    	        int position = (int) (Math.abs(abst)%Constant.PRIME);                   //该摘要值在数组中的位置
	    	    	        
	    	    	        //构造Node节点
	    	    	        Node tempnode = new Node();
	    	    	        tempnode.setBlocknum(i);
	    	    	        tempnode.setHashvalue(abst);
	    	    	        tempnode.next = null;
	    	    	        if(nodenumlist[position]==0){
	    	    	        	    nodelist[position] = tempnode;
	    	    	        }
	    	    	        else {
	    	    	        	 Node temp = nodelist[position];
    	    	        	     while(temp.getNext()!=null){
    	    	        	    	        temp = temp.getNext();
    	    	        	     }
    	    	        	     temp.setNext(tempnode);
	    	    	        }
	    	    	        nodenumlist[position]++;
	    	    	        i++;
	    	     }
				return nodelist;	 
	    }
	    
	    public boolean findHash(Node[] nodelist, int[] nodenumlist, long hashvalue){
	    				int position =(int) (Math.abs(hashvalue)%Constant.PRIME);
	    				//如果该位置没有节点
	    				if (nodenumlist[position]==0)
	    					    return false;
	    				//如果该位置有节点，逐一比较
	    				Node tempnode = nodelist[position];
	    				//String tempstr1 = Long.toString(hashvalue);
	    				while(tempnode!=null){
	    					     long templong = tempnode.getHashvalue();
	    					     if(templong == hashvalue)
	    					    	    return true;
	    					     else 
	    					    	    tempnode = tempnode.getNext();
	    				}
						return false;
	    }
}
