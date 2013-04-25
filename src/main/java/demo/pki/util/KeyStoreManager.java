package demo.pki.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.cert.Certificate;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.util.SystemInit;

public class KeyStoreManager {
	private static final KeyStore KEY_STORE;
	private static final Log log;
	
	static {
		log = LogFactory.getLog(KeyStoreManager.class);
		KEY_STORE = initKeyStore();
	}

	public static KeyStore initKeyStore() {
		File file = new File(SystemInit.demoRootDir, "my.jks");
		try {
			KeyStore keyStore = KeyStore.getInstance("jks");
			if (file.exists()) {
				keyStore.load(new FileInputStream(file),
						"password".toCharArray());
				log.info("keyStore size:" + keyStore.size());
			} else {
				KeyPairGenerator generator = KeyPairGenerator
						.getInstance("RSA");
				generator.initialize(1024);
				keyStore.load(null, null);
				for (int i = 0; i < 10; i++) {
					KeyPair keyPair = generator.generateKeyPair();
					PublicKey publicKey = keyPair.getPublic();
					PrivateKey privateKey = keyPair.getPrivate();
					X509Certificate certificate = CertUtils
							.generateCertificate(publicKey, privateKey);
					keyStore.setKeyEntry("RSAPublicKey-" + i, privateKey,
							"password".toCharArray(),
							new Certificate[] { certificate });
				}
				keyStore.store(new FileOutputStream(file),
						"password".toCharArray());
			}
			return keyStore;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Certificate getCertificate(String alias) {
		try {
			return KEY_STORE.getCertificate(alias);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PublicKey getPublicKey(String alias) {
		try {
			return KEY_STORE.getCertificate(alias).getPublicKey();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PrivateKey getPrivateKey(String alias) {
		try {
			return (PrivateKey) KEY_STORE.getKey(alias,
					"password".toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		initKeyStore();
	}
}
