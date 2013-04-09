//請參考http://blog.csdn.net/linlzk/article/details/6764666

package demo.upload.service;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends IoHandlerAdapter {

	private final int IDLE = 300;

	// private final Logger log = LoggerFactory .getLogger(HandlerTwo.class);
	private final Logger log = LoggerFactory.getLogger(ServerHandler.class);

	public static Set<IoSession> sessions = Collections
			.synchronizedSet(new HashSet<IoSession>());

	/**
     * 
     */
	public ServerHandler() {

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		session.close();
		// System.out.println("session occured exception, so close it.");
		System.out.println("session occured exception, so close it."
				+ cause.getMessage());
	}

	@Override
	public void sessionCreated(IoSession session) {
		//
		System.out.println("remote client ["
				+ session.getRemoteAddress().toString() + "] connected.");
		sessions.add(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String str = message.toString();
		System.out.println("Message written..." + str);
		System.out.println("客户端"
				+ ((InetSocketAddress) session.getRemoteAddress()).getAddress()
						.getHostAddress() + "连接成功！");
		//session.write("ok");
		if (str.trim().equalsIgnoreCase("quit")) {
			System.out.println("receive quit!");
			session.close();//
			return;
		}
		// Date date = new Date();
		// session.write(date.toString());//
		// session.setAttribute(remoteAddress, message);

		session.setAttribute("type", message);
		String remoteAddress = ((InetSocketAddress) session.getRemoteAddress())
				.getAddress().getHostAddress();
		session.setAttribute("ip", remoteAddress);

	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("sessionClosed.");
		sessions.remove(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		System.out.println("session idle, so disconnecting......");
		session.close();
		System.out.println("disconnected.");
	}

	//
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		System.out.println("messageSent.");
		// disconnect an idle client
		// session.close();
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("sessionOpened.");
		//
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDLE);
	}

}
