package imageoperation;

public class SHA_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[B@gsfasdfbgdsfbdbg";
		byte[] abs = s.getBytes();
		System.out.println(abs);
		byte[] temp = null;
		SHA1 sha = new SHA1();
		//temp = sha.sha1Digest(abs);
		abs = sha.sha1Digest(abs);
		System.out.println(abs.length);
		System.out.println(abs.toString());
		//System.out.println(temp.toString());
		return;
	}

}
