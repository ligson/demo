package demo.pki.util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.x509.X509V3CertificateGenerator;

public class CertUtils {
	public static X509Certificate generateCertificate(PublicKey publicKey,
			PrivateKey privateKey) {
		X509Name x509Name = new X509Name("o=test,ou=test,cn=test");
		X509V3CertificateGenerator generator = new X509V3CertificateGenerator();
		generator.setIssuerDN(x509Name);
		generator.setSubjectDN(x509Name);
		generator.setSerialNumber(BigInteger.probablePrime(32, new Random()));
		generator.setNotBefore(new Date());
		generator.setNotAfter(new Date(new Date().getTime() + 365 * 24 * 60
				* 60 * 1000));
		generator.setPublicKey(publicKey);
		generator.setSignatureAlgorithm("SHA1WITHRSA");
		try {
			X509Certificate certificate = generator.generate(privateKey);

			return certificate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void certificateToFile(X509Certificate x509Certificate,
			File dest) {
		try {
			byte[] buf = x509Certificate.getEncoded();
			FileUtils.writeByteArrayToFile(dest, buf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static X509Certificate fileToCertificate(File desFile) {
		try {
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			Certificate certificate = cf
					.generateCertificate(new FileInputStream(desFile));
			if (certificate != null) {
				return (X509Certificate) certificate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("E:/1.cer");
		X509Certificate certificate = fileToCertificate(file);
		System.out.println(certificate);
		System.out.println(certificate);
	}
}
