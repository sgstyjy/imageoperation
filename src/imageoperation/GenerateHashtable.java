package imageoperation;

import java.io.IOException;
import java.io.OutputStream;

public class GenerateHashtable {

	public byte[] generateHashtable(byte[] message) throws IOException{
		SHA1 sha1 = new SHA1();
		byte[] abs = new byte[20];
		abs = sha1.sha1Digest(message);
		//writer.write(abs);
		return abs;
	}
}

