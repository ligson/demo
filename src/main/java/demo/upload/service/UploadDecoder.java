package demo.upload.service;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class UploadDecoder implements ProtocolDecoder{

	@Override
	public void decode(IoSession session, IoBuffer buffer, ProtocolDecoderOutput decoderOutput)
			throws Exception {
		String string = new String(buffer.array());
		System.out.println(session+"ccc");
		System.out.println(string);
		decoderOutput.write(string);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		System.out.println(session+"ddd");
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput arg1)
			throws Exception {
		System.out.println(session+"eee");
	}
}
