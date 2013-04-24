package demo.app.service;


import javax.crypto.Cipher;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import demo.pki.util.KeyStoreManager;

public class AppDecoder implements ProtocolDecoder{
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
		byte[] source = in.array();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, keyStoreManager.getPrivateKey("rsapublickey-9"));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		out.write(result);
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out)
			throws Exception {
	}

	@Override
	public void dispose(IoSession session) throws Exception {
	}

}
