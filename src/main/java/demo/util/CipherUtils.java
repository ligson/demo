package demo.util;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class CipherUtils {

	public static final String publicKeyBase64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCn3nxNtfxQuIQjt48k7qbThQwhjwZKOS8q9E8o0EQz1tLm4yJvO1NjMOsrT8QWSRoHbeDo9xFVkpkhy6c/ODgBk/R/uhAR6y19gqC3Nky38VB0/IdGXaEoKI3lAa4pvf5x4ByOXv2pHPdo7ehB2CiX8+DcPsmvXqvx5bc5XbJg5wIDAQAB";
	public static final String privateKeyBase64 = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKfefE21/FC4hCO3jyTuptOFDCGPBko5Lyr0TyjQRDPW0ubjIm87U2Mw6ytPxBZJGgdt4Oj3EVWSmSHLpz84OAGT9H+6EBHrLX2CoLc2TLfxUHT8h0ZdoSgojeUBrim9/nHgHI5e/akc92jt6EHYKJfz4Nw+ya9eq/HltzldsmDnAgMBAAECgYAydoJdhgiMZ3tplUOVsZw617MW33zfkSMpwXmOZlUqVDjgKYVvdKETn2ACjB8BKAaIFzLWNXdjhwc7jpH/QjIrYmJmCKu9F7G+NpX6gnH/x95ihllozx9yhCqxBr5+ciiOxS1m3qQ1Shei0CbicMposifN0WPM3QtSNvWen2Pq2QJBANyy0lrMzBuOvY9NbvxO52nL5fPt/lEDKhz0B2oqCi/V2vxZf7Wv6qpgXDwmSfH8E/df8ohhv98Jv2j4s/Rw/RMCQQDCuGaAINP2b6WUstc5D/BKADT/8ge712swbJCo/+d2rYjfUM+jezLio/rocQT2ay461/Lo8hZXJ2/hrD5fEutdAkAC46xxV+EMM1A0AhWD5ByPfAXkrab4tIvmmSNHtokvmyMkzp8nZ8gwttY+S1oIev5f7LemJXF3oA8LdsYUWy5VAkAWZkYMSTp45+EBWQ1fGBFJQfrW0o3HMwG2oVaGymFjCpVrMw2fvcVdwwVTBeVPP4ci58Kev3KIdhXtvPWz1CZVAkBpvyc2jsl857uQmmbgaSiMfqeNK/aWU8UTZrNmb+1gRX5PUVQD1SI1MmJwyp9t01vk0VyNpvpYCbJBguoEFrcQ";

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
