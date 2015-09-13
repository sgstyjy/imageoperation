package imageoperation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_test {

	//public static void main(String[] args) throws Exception {
	public void SHA1_test()
		// TODO Auto-generated method stub
		String s = "sdvsfasdbg";
		byte[] abs = s.getBytes();
		System.out.println(s);
		byte[] temp = null;
		//SHA1 sha = new SHA1();
		//temp = sha.sha1Digest(abs);
	 	MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        //System.out.println(sha1.getDigestLength());
	 	
	 	sha1.update(abs);
	 	temp = sha1.digest(abs);
	 	System.out.println(bytesToHex(temp));

		return;
	}
	   public static String bytesToHex(byte[] b) {
		      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
		                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		      StringBuffer buf = new StringBuffer();
		      System.out.println(b.length);
		      for (int j=0; j<b.length; j++) {
		         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
		         buf.append(hexDigit[b[j] & 0x0f]);
		      }
		      return buf.toString();
		   }

}
