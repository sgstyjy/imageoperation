package imageoperation;

public class SHA_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "fafafafafdfafegababaafafa";
		byte[] abs= s.getBytes();
		SHA1 sha = new SHA1();
		abs = sha.sha1Digest(abs);
		System.out.println(abs.length);
		System.out.println(abs);
		return;
	}

}
