//請參考http://blog.csdn.net/linlzk/article/details/6764666

/*package demo.upload.service;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;


public class ServerHandler extends IoHandlerAdapter {

	private final int IDLE = 300;
	
	 //private final Logger log = LoggerFactory .getLogger(HandlerTwo.class);
	 private final Logger log = Logger.getLogger(ServerHandler.class.getName());

	 public static Set<IoSession> sessions = Collections .synchronizedSet(new HashSet<IoSession>());
	 
    *//**
     * 
     *//*
	public ServerHandler(){
		
	}

	@Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        session.close();
        //log.debug("session occured exception, so close it.");
        log.debug("session occured exception, so close it." + cause.getMessage());
    }
	
	@Override
	public void sessionCreated(IoSession session) {
		// 
		log.debug("remote client ["+session.getRemoteAddress().toString()+"] connected.");
		session.write("Welcome");
		sessions.add(session);
	}
	
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String str = message.toString();
		log.debug("Message written..." + str);
		log.debug("客户端"+((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress()+"连接成功！");
		if (str.trim().equalsIgnoreCase("quit")) {
			session.close();// 
			return;
		}
		//Date date = new Date();
		//session.write(date.toString());// 
		//session.setAttribute(remoteAddress, message);
		
		session.setAttribute("type", message);
		String remoteAddress = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
		session.setAttribute("ip", remoteAddress);
		
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		 log.debug("sessionClosed.");
		sessions.remove(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		log.debug("session idle, so disconnecting......");
        session.close();
        log.debug("disconnected.");
	}
	
	// 
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		 log.debug("messageSent.");
		// disconnect an idle client
		//session.close();
    }
	
	@Override
    public void sessionOpened(IoSession session) throws Exception {
		log.debug("sessionOpened.");
        //
        session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDLE);
    }

}
*/