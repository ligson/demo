package demo.app.service;

import javax.crypto.Cipher;

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
		byte[] source = message.toString().getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,
				keyStoreManager.getPublicKey("rsapublickey-9"));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		out.write(result);
	}

	@Override
	public void dispose(IoSession session) throws Exception {

	}

}
