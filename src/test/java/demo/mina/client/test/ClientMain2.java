package demo.mina.client.test;

import java.io.OutputStream;
import java.net.Socket;

import javax.crypto.Cipher;

import demo.pki.util.KeyStoreManager;

public class ClientMain2 {
	private static KeyStoreManager keyStoreManager = new KeyStoreManager();

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 8822);
		OutputStream outputStream = socket.getOutputStream();
		String message = "niasdfasdhao";
		byte[] source = message.toString().getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,
				keyStoreManager.getPublicKey("rsapublickey-9"));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		outputStream.write(result);
		System.out.println("dddd");
	}
}
