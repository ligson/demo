package demo.test;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class SamplMinaClientHandler extends IoHandlerAdapter {  
    //当客户端连接进入时  
    @Override  
    public void sessionOpened(IoSession session) throws Exception {  
          
        System.out.println("incomming 客户端: "+session.getRemoteAddress());  
    }  
  
    //当客户端发送消息到达时  
    @Override  
    public void messageReceived(IoSession session, Object message)  
            throws Exception {  
          
        IoBuffer by = (IoBuffer)message;  
        byte[] b = new byte[by.limit()];   
        by.get(b);  
          
        System.out.println("服务器返回的数据："+new String(b));  
    }  
}  