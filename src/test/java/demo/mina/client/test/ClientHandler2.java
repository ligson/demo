package demo.mina.client.test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientHandler2 extends IoHandlerAdapter {
	// 当客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("incomming 客户端: " + session.getRemoteAddress());
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		System.out.println("客户端发送信息异常....");
		cause.printStackTrace();
	}

	// 当客户端发送消息到达时
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {

		System.out.println("服务器返回的数据：" + message.toString());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("客户端与服务端断开连接.....");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out
				.println("one Client Connection" + session.getRemoteAddress());
		//session.write("我来了······");
		session.write("为什么呢？？？？");
	}

}
