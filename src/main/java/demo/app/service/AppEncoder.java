package demo.app.service;

import java.security.Signature;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import demo.pki.util.KeyStoreManager;

public class AppEncoder implements ProtocolEncoder {

	private KeyStoreManager keyStoreManager;

	public KeyStoreManager getKeyStoreManager() {
		return keyStoreManager;
	}

	public void setKeyStoreManager(KeyStoreManager keyStoreManager) {
		this.keyStoreManager = keyStoreManager;
	}

	@Override
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		byte[] source = message.toString().getBytes("UTF-8");
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,
				keyStoreManager.getPublicKey("RSAPublicKey-9"));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		result = Base64.encodeBase64(result);
		
		//签名
		Signature signature = Signature.getInstance("SHA1withRSA");
		signature.initSign(keyStoreManager.getPrivateKey("RSAPublicKey-9"));
		signature.update(Base64.encodeBase64(source));
		byte[] sign = signature.sign();
		
		sign = Base64.encodeBase64(sign);
		
		IoBuffer ioBuffer = IoBuffer.allocate(1024).setAutoExpand(true);
		ioBuffer.putInt(result.length+sign.length);
		ioBuffer.putInt(result.length);
		ioBuffer.putInt(sign.length);
		ioBuffer.put(result);
		ioBuffer.put(sign);
		ioBuffer.flip();
		out.write(ioBuffer);
		System.out.println("编码发送消息结果1:"+Arrays.toString(result));
		System.out.println("编码发送消息结果2:"+Arrays.toString(ioBuffer.array()));
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		
	}

}
