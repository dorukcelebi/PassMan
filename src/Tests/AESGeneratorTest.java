package Tests;

import org.junit.Test;

import PassMan.AESGenerator;
import junit.framework.TestCase;

public class AESGeneratorTest extends TestCase {

	public void caninstantitateAESGenerator() {
		AESGenerator aes = new AESGenerator();
		assertNotNull(aes);
	}

	@Test
	public void testEncryption() throws Exception {
		AESGenerator enc = new AESGenerator();

		String testString = "testpass";
		byte[] encryptedPass = enc.encrypt(testString);

		assertEquals(testString, enc.decrypt(encryptedPass));
	}

}
