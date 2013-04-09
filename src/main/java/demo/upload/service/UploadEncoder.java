package demo.upload.service;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class UploadEncoder implements ProtocolEncoder{

	@Override
	public void dispose(IoSession session) throws Exception {
		System.out.println(session+"aaaaaa");
	}

	@Override
	public void encode(IoSession session, Object object, ProtocolEncoderOutput encoderOutput)
			throws Exception {
		System.out.println(session+"bbbbbb");
		encoderOutput.write(object.toString().getBytes());
		
	}

}
