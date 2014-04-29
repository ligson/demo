package demo.pki.util;

import java.io.ByteArrayOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Arrays;

import javax.crypto.Cipher;

public class RSACryptoUtils {

	/**
	 * RSA最大加密明文大小,只适应与密钥长度为1024
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小,只适应与密钥长度为1024
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	public static byte[] encrypt(PublicKey publicKey, byte[] buffer) {
		try {
			System.out.println(publicKey);
			// 对数据加密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			int inputLen = buffer.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段加密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
					cache = cipher.doFinal(buffer, offSet, MAX_ENCRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(buffer, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * MAX_ENCRYPT_BLOCK;
			}
			byte[] encryptedData = out.toByteArray();
			out.close();
			return encryptedData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static byte[] decrypt(PrivateKey privateKey, byte[] encryptedData) {
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			int inputLen = encryptedData.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段解密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
					cache = cipher.doFinal(encryptedData, offSet,
							MAX_DECRYPT_BLOCK);
				} else {
					cache = cipher.doFinal(encryptedData, offSet, inputLen
							- offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * MAX_DECRYPT_BLOCK;
			}
			byte[] decryptedData = out.toByteArray();
			out.close();
			return decryptedData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] sign(PrivateKey privateKey, byte[] buffer) {
		try {
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initSign(privateKey);
			signature.update(buffer);
			return signature.sign();
		} catch (Exception e) {
		}
		return null;
	}

	public static boolean verify(PublicKey publicKey, byte[] signData,
			byte[] buffer) {
		try {
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initVerify(publicKey);
			signature.update(buffer);
			return signature.verify(signData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		// generator.initialize(2048);
		KeyPair keyPair = generator.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// 加解密测试
		String source = "boful_license客户端:zhangsan0开始时间:2014-04-29 08:32:14.0结束时间:2080-12-30 00:00:00.0[{'clientName':'zhangsan0','macList':['8884','8883','8880','8882','8881'],'validDate':['20140429083214','20801230000000']}, {'clientName':'zhangsan1','macList':['8883','8884','8880','8881','8882'],'validDate':['20140429083214','20801230000000']}, {'clientName':'zhangsan2','macList':['8884','8880','8882','8883','8881'],'validDate':['20140429083214','20801230000000']}, {'clientName':'zhangsan3','macList':['8883','8881','8884','8880','8882'],'validDate':['20140429083214','20801230000000']}, {'clientName':'zhangsan4','macList':['8883','8882','8884','8880','8881'],'validDate':['20140429083214','20801230000000']}]";
		byte[] sourceBytes = source.getBytes();
		byte[] buffer = encrypt(publicKey, sourceBytes);
		System.out.println(Arrays.toString(buffer));
		byte[] buffer2 = decrypt(privateKey, buffer);
		String result = new String(buffer2);
		System.out.println(result);
		System.out.println(source.equals(result));

		// 签名测试
		// 把原文做一个信息摘要
		MessageDigest digest = MessageDigest.getInstance("SHA1");
		digest.update(source.getBytes("UTF-8"));
		byte[] hash = digest.digest();

		byte[] signData = sign(privateKey, hash);
		boolean result2 = verify(publicKey, signData, hash);
		System.out.println(result2);

	}

}
