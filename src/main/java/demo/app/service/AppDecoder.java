package demo.app.service;


import java.util.Arrays;

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
		System.out.println("decode ....................");
		byte[] source = in.array();
		int max = 0;
		for(int i = source.length-1;i>=0;i--){
			if(source[i]!=0){
				max = i;
				break;
			}
		}
		byte[] result = new byte[max+1];
		System.arraycopy(source, 0, result, 0, result.length);
		System.out.println(Arrays.toString(source));
		System.out.println(Arrays.toString(result));
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, keyStoreManager.getPrivateKey("rsapublickey-9"));
		cipher.update(result);
		byte[] result2 = cipher.doFinal();
		System.out.println(new String(result2));
		out.write(new String(result2));
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
