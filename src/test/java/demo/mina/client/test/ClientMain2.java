package demo.mina.client.test;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.Signature;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.mina.core.buffer.IoBuffer;

import demo.pki.util.KeyStoreManager;

public class ClientMain2 {
	private static KeyStoreManager keyStoreManager = new KeyStoreManager();
	public static void send(String message,Socket socket,String alias) throws Exception{
		BufferedOutputStream outputStream = new BufferedOutputStream(
				socket.getOutputStream());
		byte[] source = message.toString().getBytes("UTF-8");
		
		//加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,
				keyStoreManager.getPublicKey(alias));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		System.out.println("密文值："+Arrays.toString(result));
		
		//签名
		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initSign(keyStoreManager.getPrivateKey(alias));
		signature.update(Base64.encodeBase64(source));
		byte[] sign = signature.sign();
		System.out.println("签名值："+Arrays.toString(sign));
		
		//开始封装数据
		IoBuffer ioBuffer = IoBuffer.allocate(1024).setAutoExpand(true);
		
		//编码
		byte[] cipherBuffer = Base64.encodeBase64(result);
		byte[] signBuffer = Base64.encodeBase64(sign);
		
		//四个字节的总长度
		ioBuffer.putInt(cipherBuffer.length+signBuffer.length);
		System.out.println("总长度:"+(cipherBuffer.length+signBuffer.length));
		//密文长度
		ioBuffer.putInt(cipherBuffer.length);
		System.out.println("密文长度:"+cipherBuffer.length);
		//签名值长度
		ioBuffer.putInt(signBuffer.length);
		System.out.println("签名值长度:"+cipherBuffer.length);
		ioBuffer.put(cipherBuffer);
		ioBuffer.put(signBuffer);
		ioBuffer.flip();
		
		outputStream.write(ioBuffer.array());
		outputStream.flush();
		System.out.println(Arrays.toString(ioBuffer.array()));
		System.out.println("发送完成");
	}
	
	public static void receive(Socket socket,String alias) throws Exception{
		InputStream inputStream = socket.getInputStream();
		Cipher cipher = Cipher.getInstance("RSA");
		int r;
		IoBuffer ioBuffer = IoBuffer.allocate(1024).setAutoExpand(true);
		byte[] bufSign = new byte[12];
		inputStream.read(bufSign);
		int size = new BigInteger(Arrays.copyOfRange(bufSign, 0, 4)).intValue();
		int cipherSize = new BigInteger(Arrays.copyOfRange(bufSign, 4, 8)).intValue();
		int signSize = new BigInteger(Arrays.copyOfRange(bufSign, 8, 12)).intValue();
		byte[] cipherBuffer = new byte[cipherSize];
		inputStream.read(cipherBuffer);
		byte[] signBuffer = new byte[signSize];
		inputStream.read(signBuffer);
		
		System.out.println("len:"+Arrays.toString(bufSign));
		inputStream.close();

		cipherBuffer = Base64.decodeBase64(cipherBuffer);
		cipher.init(Cipher.DECRYPT_MODE, keyStoreManager.getPrivateKey(alias));
		cipher.update(cipherBuffer);
		cipherBuffer = cipher.doFinal();
		
		String source = new String(cipherBuffer,"UTF-8");
		System.out.println(source);
		
		//验证签名
		signBuffer = Base64.decodeBase64(signBuffer);
		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initVerify(keyStoreManager.getPublicKey("RSAPublicKey-9"));
		signature.update(Base64.encodeBase64(source.getBytes("UTF-8")));
		boolean verify = signature.verify(signBuffer);
		System.out.println("验证签名结果:" + verify);
		
		// System.out.println(Arrays.toString(buf));
	}
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 8822);
		String alias = "RSAPublicKey-9";
		send("你哄啊阿斯蒂芬阿萨德发射点发", socket, alias);
		receive(socket, alias);

		

	}
}
