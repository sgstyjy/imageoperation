package imageoperation;

import java.security.MessageDigest;

public class SHA1 {

	// public static void main(String[] args) throws Exception {
	    public String generateAbstract(byte [] message) {
		// TODO Auto-generated method stub
		//String s = "sdvsfasdbg";
		//byte[] abs = message.getBytes();
		//System.out.println(abs.length);
		byte[] temp = null;
		try{
					MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
					sha1.update(message);
					temp = sha1.digest(message);
					//System.out.println(bytesToHex(temp));
		}catch(Exception e){
			System.out.println("Exception: "+e);
		}
		return bytesToHex(temp);
	}
	   public static String bytesToHex(byte[] b) {
		      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
		                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		      StringBuffer buf = new StringBuffer();
		      //System.out.println(b.length);
		      for (int j=0; j<b.length; j++) {
		         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
		         buf.append(hexDigit[b[j] & 0x0f]);
		      }
		      return buf.toString();
		   }

}
