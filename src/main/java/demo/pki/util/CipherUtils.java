package demo.pki.util;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

public class CipherUtils {
	
	public static PublicKey byte2PublicKey(byte[] buf) {
		byte size = buf[0];
		byte size2 = buf[1];
		byte[] b1 = new byte[size];
		System.arraycopy(buf, 2, b1, 0, b1.length);
		byte[] b2 = new byte[size2];
		System.arraycopy(buf, b1.length + 2, b2, 0, b2.length);
		BigInteger B1 = new BigInteger(b1);
		BigInteger B2 = new BigInteger(b2);
		RSAPublicKeySpec spec = new RSAPublicKeySpec(B1, B2);// 存储的就是这两个大整形数
		KeyFactory keyFactory;
		PublicKey pk = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			pk = keyFactory.generatePublic(spec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (RSAPublicKey) pk;
	}

	public static PrivateKey byte2PrivateKey(byte[] buf) {
		try {

			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(buf);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
			return privateK;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
