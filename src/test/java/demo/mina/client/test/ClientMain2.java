package demo.mina.client.test;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import javax.crypto.Cipher;

import demo.pki.util.KeyStoreManager;

public class ClientMain2 {
	private static KeyStoreManager keyStoreManager = new KeyStoreManager();

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 8822);
		BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
		String message = "niasdfasdhao";
		byte[] source = message.toString().getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,
				keyStoreManager.getPublicKey("rsapublickey-9"));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		outputStream.write(result);
		outputStream.flush();
		System.out.println("dddd");
		System.out.println(Arrays.toString(result));
	}
}
