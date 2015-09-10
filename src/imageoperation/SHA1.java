package imageoperation;

import java.security.MessageDigest;

public class SHA1{
    public  byte[] sha1Digest(String message) {
	     byte[] buffer = message.getBytes();
	     //int numRead = message.length();
	     MessageDigest sha1;
	     try {
		        sha1 = MessageDigest.getInstance("SHA-1");
		        //System.out.println(sha1.getDigestLength());
		        sha1.update(buffer);
			    return sha1.digest();
	     } catch (Exception e) {
	    	 System.out.println("error");
	    	 return null;
	    } 
    }
}