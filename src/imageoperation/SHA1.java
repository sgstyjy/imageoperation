package imageoperation;

import java.security.MessageDigest;

public class SHA1{
    public  byte[] sha1Digest(byte[] message) {
	     //byte[] buffer = message.getBytes();
	     //int numRead = message.length();
	     try {
	    	 	MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		        //System.out.println(sha1.getDigestLength());
		        sha1.update(message);
			    return sha1.digest();
	     } catch (Exception e) {
	    	 System.out.println("error");
	    	 return null;
	    } 
    }
}