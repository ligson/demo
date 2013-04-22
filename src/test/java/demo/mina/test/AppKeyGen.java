package demo.mina.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

import demo.util.CipherUtils;

public class AppKeyGen {
	public void test() throws Exception{
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		KeyPair keyPair = generator.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		System.out.println(Base64.encodeBase64String(publicKey.getEncoded()));
		System.out.println(Base64.encodeBase64String(privateKey.getEncoded()));
		
		System.out.println(Arrays.toString(publicKey.getEncoded()));
		System.out.println(Arrays.toString(publicKey.getModulus().toByteArray()));
		System.out.println(Arrays.toString(publicKey.getPublicExponent().toByteArray()));

		System.out.println("private key ................");
		System.out.println(Arrays.toString(privateKey.getEncoded()));
		System.out.println(Arrays.toString(privateKey.getModulus().toByteArray()));
		System.out.println(Arrays.toString(privateKey.getPrivateExponent().toByteArray()));
		
		System.out.println(Base64.encodeBase64String(publicKey.getModulus().toByteArray()));
		System.out.println(Base64.encodeBase64String(publicKey.getPublicExponent().toByteArray()));
		System.out.println(Base64.encodeBase64String(privateKey.getModulus().toByteArray()));
		System.out.println(Base64.encodeBase64String(privateKey.getPrivateExponent().toByteArray()));
		
		byte[] source = "demo".getBytes();
		System.out.println(Arrays.toString(source));
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		cipher.update(source);
		byte[] enc = cipher.doFinal();
		System.out.println(Arrays.toString(enc));
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		cipher.update(enc);
		byte[] result = cipher.doFinal();
		System.out.println(Arrays.toString(result));
	}
	public static void main(String[] args) throws Exception{
		
		String base64 = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfefE21/FC4hCO3jyTuptOFDCGPBko5Lyr0TyjQRDPW0ubjIm87U2Mw6ytPxBZJGgdt4Oj3EVWSmSHLpz84OAGT9H+6EBHrLX2CoLc2TLfxUHT8h0ZdoSgojeUBrim9/nHgHI5e/akc92jt6EHYKJfz4Nw+ya9eq/HltzldsmDnAgMBAAECgYAydoJdhgiMZ3tplUOVsZw617MW33zfkSMpwXmOZlUqVDjgKYVvdKETn2ACjB8BKAaIFzLWNXdjhwc7jpH/QjIrYmJmCKu9F7G+NpX6gnH/x95ihllozx9yhCqxBr5+ciiOxS1m3qQ1Shei0CbicMposifN0WPM3QtSNvWen2Pq2QJBANyy0lrMzBuOvY9NbvxO52nL5fPt/lEDKhz0B2oqCi/V2vxZf7Wv6qpgXDwmSfH8E/df8ohhv98Jv2j4s/Rw/RMCQQDCuGaAINP2b6WUstc5D/BKADT/8ge712swbJCo/+d2rYjfUM+jezLio/rocQT2ay461/Lo8hZXJ2/hrD5fEutdAkAC46xxV+EMM1A0AhWD5ByPfAXkrab4tIvmmSNHtokvmyMkzp8nZ8gwttY+S1oIev5f7LemJXF3oA8LdsYUWy5VAkAWZkYMSTp45+EBWQ1fGBFJQfrW0o3HMwG2oVaGymFjCpVrMw2fvcVdwwVTBeVPP4ci58Kev3KIdhXtvPWz1CZVAkBpvyc2jsl857uQmmbgaSiMfqeNK/aWU8UTZrNmb+1gRX5PUVQD1SI1MmJwyp9t01vk0VyNpvpYCbJBguoEFrcQ";
		PrivateKey privateKey = CipherUtils.byte2PrivateKey(Base64.decodeBase64(base64));
		System.out.println(privateKey);
	}
}
