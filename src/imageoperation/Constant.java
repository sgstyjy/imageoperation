package imageoperation;

public class Constant {
	public static int BUFFER_SIZE = 20*1024;
	public static int COLUMNS = 10000;
	public static int PRIME = 10007;
	public static int[]  nodenumlistbkdr = new int[Constant.PRIME];
	public static int[]  nodenumlistap = new int[Constant.PRIME];
	
	public static int similar = 0;
	
	public static int U12_4K_TNUM =382528;
	public static int U14WEB_4K_TNUM =524287;
	public static int U14DEV_4K_TNUM =524287;
	
	public static int U12_8K_TNUM =191264;
	public static int U14WEB_8K_TNUM =262143;
	public static int U14DEV_8K_TNUM =262143;
	
	public static int U12_12K_TNUM =127509;
	public static int U14WEB_12K_TNUM =174762;
	public static int U14DEV_12K_TNUM =174762;
	
	public static int U12_16K_TNUM =95632;
	public static int U14WEB_16K_TNUM =131071;
	public static int U14DEV_16K_TNUM =131071;
	
	public static int U12_20K_TNUM =76505;
	public static int U14WEB_20K_TNUM =104857;
	public static int U14DEV_20K_TNUM =104857;
	

	//hashtest.qcow2输入
	public static String UBUNTU12SERVER= "ubuntu12server.qcow2";   
	public static String UBUNTU14WEBSERVER = "ubuntun14server.qcow2";
	public static String UBUNTU14DEVELOP= "ubuntun14develop.qcow2";
	
	
	//BKDR和AP哈希输出结果
	public static String U12_4K = "ubuntu12_4k.xls";       //blocknum:382528 , compute time: 12711
	public static String U14WEB_4K = "ubuntu14webserver_4k.xls";       //blocknum:524287 , compute time: 19763
	public static String U14DEV_4K = "ubuntu14develop_4k.xls";    //blocknum:524287, compute time: 18190
	
	public static String U12_8K = "ubuntu12_8k.xls";       //blocknum: 191264 , compute time: 11183
	public static String U14WEB_8K = "ubuntu14webserver_8k.xls";       //blocknum:262143 , compute time:  16517
	public static String U14DEV_8K = "ubuntu14develop_8k.xls";    //blocknum: 262143, compute time: 16110
	
	public static String U12_12K = "ubuntu12_12k.xls";       //blocknum: 127509, compute time: 11203
	public static String U14WEB_12K = "ubuntu14webserver_12k.xls";       //blocknum:174762 , compute time: 16008
	public static String U14DEV_12K = "ubuntu14develop_12k.xls";    //blocknum: 174762, compute time: 15622
	
	public static String U12_16K = "ubuntu12_16k.xls";       //blocknum: 95632, compute time:  10968
	public static String U14WEB_16K = "ubuntu14webserver_16k.xls";       //blocknum: 131071, compute time: 15937
	public static String U14DEV_16K = "ubuntu14develop_16k.xls";    //blocknum: 131071, compute time: 15287
	
	public static String U12_20K = "ubuntu12_20k.xls";       //blocknum: 76505, compute time:  10914
	public static String U14WEB_20K = "ubuntu14webserver_20k.xls";       //blocknum: 104857, compute time: 15402
	public static String U14DEV_20K = "ubuntu14develop_20k.xls";    //blocknum: 104857, compute time: 15322

	//public static String PATH_IN_PDF = "test.pdf";
	//public static String PATH_IN_MKV = "test.mkv";
	//public static String PATH_IN_TXT = "test.txt";
	//public static String PATH_OUT_PDF = "result.pdf";
	//public static String PATH_OUT_MKV = "result.mkv";
	//public static String PATH_OUT_ISO = "result.iso";
	//public static String PAHT_OUT_TXT = "result.txt";
	/*
	//Ubuntu输入
	public static String UBUNTU_ISO1 = "ubuntu1.iso";      //4k, blocknum: 252672
	public static String UBUNTU_ISO2 = "ubuntu2.iso";      //4k, blocknum: 146432
	public static String UBUNTU_ISO1_C = "ubuntu1_c.iso"; 
	
	public static String U1_4K = "ubuntu1_4k.xls";      //blocknum:252672, compute time: 9092
	public static String U2_4K= "ubuntu2_4k.xls";       //blocknum:146432, compute time: 5472
	public static String U1_C_4K= "ubuntu1_c_4k.xls";   //blocknum:252672, compute time: 9274
	*/
	
	/*
	//SHA1哈希输出结果
	public static String U12_4K = "ubuntu12server_4k.xls";       //blocknum: 382528, compute time: 14166
	public static String U14_4K = "ubuntu14server_4k.xls";       //blocknum: 426320, compute time: 15628
	public static String U14WEB_4K = "ubuntu14webserver_4k.xls";    //blocknum:468416, compute time: 17211
	
	public static String U12_8K = "ubuntu12server_8k.xls";       //blocknum: 191264 , compute time: 13064
	public static String U14_8K = "ubuntu14server_8k.xls";       //blocknum: 213160, compute time: 15089 
	public static String U14WEB_8K = "ubuntu14webserver_8k.xls";    //blocknum: 234208, compute time: 16257
	
	public static String U12_12K = "ubuntu12server_12k.xls";       //blocknum: 127509, compute time: 13005
	public static String U14_12K = "ubuntu14server_12k.xls";       //blocknum:142106 , compute time: 15001
	public static String U14WEB_12K = "ubuntu14webserver_12k.xls";    //blocknum:156138 , compute time: 16220
	
	public static String U12_16K = "ubuntu12server_16k.xls";       //blocknum: 95632, compute time:  13117
	public static String U14_16K = "ubuntu14server_16k.xls";       //blocknum: 106580, compute time: 14788
	public static String U14WEB_16K = "ubuntu14webserver_16k.xls";    //blocknum: 117104, compute time: 15682
	
	//最初测试qcow2镜像时输出结果
	public static String Q1_4K = "hashtest1_4k.xls";       //blocknum:524287, compute time: 19573
	public static String Q2_4K = "hashtest2_4k.xls";       //blocknum:524287, compute time: 19373
	public static String Q1_C_4K = "hashtest1_c_4k.xls";    //blocknum:524287, compute time: 19568
	
	public static String Q1_16K = "hashtest1_16k.xls";      //blocknum:131071, compute time:17544
	public static String Q2_16K = "hashtest2_16k.xls";       //bocknum:131071, compute time: 17627
	public static String Q1_C_16K = "hashtest1_c_16k.xls";     //blocknum:131071, compute time: 17357
	
	public static String Q1_4K_TXT = "hashtest1_4k.txt";       //blocknum:524287, compute time: 19573
	public static String Q2_4K_TXT = "hashtest2_4k.txt";       //blocknum:524287, compute time: 19373
	public static String Q1_C_4K_TXT = "hashtest1_c_4k.txt";    //blocknum:524287, compute time: 19568
	*/
	//比较结果输出
	public static String COM_U1_U2_4K = "com_u1_u2_4k.xls";
	public static String COM_U1_U1_C_4K = "com_u1_u1_c_4k.xls";
	
	public static String COM_Q1_Q2_4K = "com_q1_q2_4k.xls";
	public static String COM_Q1_Q1_C_4K = "com_q1_q1_c_4k.xls";
	
	public static String COM_Q1_Q2_4K_TXT = "com_q1_q2_4k_txt.xls";
	
	public static String COM_Q1_Q2_16K = "com_q1_q2_16k.xls";
	public static String COM_Q1_Q1_C_16K = "com_q1_q1_c_16k.xls";

}
