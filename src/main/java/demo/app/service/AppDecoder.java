package demo.app.service;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import demo.util.CipherUtils;

public class AppDecoder implements ProtocolDecoder{

	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
			throws Exception {
		byte[] source = in.array();
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, CipherUtils.byte2PrivateKey(Base64.decodeBase64(CipherUtils.privateKeyBase64)));
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
