package demo.app.service;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class AppCodec implements ProtocolCodecFactory{

	private AppEncoder appEncoder;
	private AppDecoder appDecoder;
	
	public AppEncoder getAppEncoder() {
		return appEncoder;
	}

	public void setAppEncoder(AppEncoder appEncoder) {
		this.appEncoder = appEncoder;
	}

	public AppDecoder getAppDecoder() {
		return appDecoder;
	}

	public void setAppDecoder(AppDecoder appDecoder) {
		this.appDecoder = appDecoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return appEncoder;
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return appDecoder;
	}

}
