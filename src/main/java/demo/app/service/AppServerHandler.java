package demo.app.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class AppServerHandler extends IoHandlerAdapter {
	public static Set<IoSession> sessions = Collections
			.synchronizedSet(new HashSet<IoSession>());

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		sessions.add(session);
		System.out.println("session create");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		sessions.remove(session);
		System.out.println("session closed");
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		super.messageReceived(session, message);
		System.out.println(message);
		session.close(true);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
	}

}
