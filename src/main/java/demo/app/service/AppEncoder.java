package demo.app.service;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import demo.util.CipherUtils;

public class AppEncoder implements ProtocolEncoder{

	@Override
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		byte[] source = message.toString().getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, CipherUtils.byte2PublicKey(Base64.decodeBase64(CipherUtils.publicKeyBase64)));
		cipher.update(source);
		byte[] result = cipher.doFinal();
		out.write(result);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		
	}

}
