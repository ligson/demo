package demo.app.service;

import java.math.BigInteger;
import java.security.Signature;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import demo.pki.util.KeyStoreManager;

public class AppDecoder implements ProtocolDecoder {
	private KeyStoreManager keyStoreManager;

	public KeyStoreManager getKeyStoreManager() {
		return keyStoreManager;
	}

	public void setKeyStoreManager(KeyStoreManager keyStoreManager) {
		this.keyStoreManager = keyStoreManager;
	}

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
			throws Exception {
		System.out.println("decode ....................");
		IoBuffer buffer = IoBuffer.allocate(1024).setAutoExpand(true);
		while (in.hasRemaining()) {
			byte b = in.get();
			buffer.put(b);
		}
		byte[] buffer2 = buffer.array();

		byte[] len = Arrays.copyOfRange(buffer2, 0, 4);
		byte[] cipherLen = Arrays.copyOfRange(buffer2, 4, 8);
		byte[] signBufferLen = Arrays.copyOfRange(buffer2, 8, 12);
		int length = new BigInteger(len).intValue();
		int cipherSize = new BigInteger(cipherLen).intValue();
		int signSize = new BigInteger(signBufferLen).intValue();
		System.out.println("len:"+length+";cipher:"+cipherSize+";signSize:"+signSize);
		byte[] cipherBuffer = new byte[cipherSize];
		System.arraycopy(buffer2, 12, cipherBuffer, 0, cipherBuffer.length);

		cipherBuffer = Base64.decodeBase64(cipherBuffer);
		System.out.println("密文值:" + Arrays.toString(cipherBuffer));
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE,
				keyStoreManager.getPrivateKey("rsapublickey-9"));
		cipher.update(cipherBuffer);
		byte[] result2 = cipher.doFinal();
		String decrpty = new String(result2, "UTF-8");
		System.out.println("解密结果:" + decrpty);

		byte[] signBuffer = new byte[signSize];
		System.arraycopy(buffer2, 12 +cipherSize, signBuffer, 0,
				signBuffer.length);

		signBuffer = Base64.decodeBase64(signBuffer);
		System.out.println("签名值:" + Arrays.toString(signBuffer));

		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initVerify(keyStoreManager.getPublicKey("RSAPublicKey-9"));
		signature.update(Base64.encodeBase64(decrpty.getBytes("UTF-8")));
		boolean verify = signature.verify(signBuffer);
		System.out.println("验证签名结果:" + verify);
		out.write(decrpty);
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out)
			throws Exception {
		System.out.println("finish decode");
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		System.out.println(" decode dispose");
	}

}
