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

import demo.util.SystemInit;

public class KeyStoreManager {
	private static final KeyStore KEY_STORE;
	static {
		KEY_STORE = initKeyStore();
	}

	public static KeyStore initKeyStore() {
		File file = new File(SystemInit.demoRootDir, "my.jks");
		try {
			KeyStore keyStore = KeyStore.getInstance("jks");
			if (file.exists()) {
				keyStore.load(new FileInputStream(file),
						"password".toCharArray());
				System.out.println("keyStore size:" + keyStore.size());
				Enumeration<String> aliases = keyStore.aliases();
				while (aliases.hasMoreElements()) {
					String alias = (String) aliases.nextElement();
					System.out.println(alias);
					System.out.println(keyStore.getCertificate(alias));
					System.out.println(keyStore.getKey(alias,
							"password".toCharArray()));
				}
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
