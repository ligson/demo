package demo.test;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClientTest {
	public static void main(String[] args) {
		//创建 tcp/ip 连接  
        NioSocketConnector connector = new NioSocketConnector();  
          
        //创建接收数据的过滤器  
        DefaultIoFilterChainBuilder chin = connector.getFilterChain();  
          
        //设定这个过滤器将一行一行的读取数据  
        chin.addLast("mychin", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));  
          
        //设定客户端消息处理器  
        connector.setHandler(new SamplMinaClientHandler());  
        //设置连接超时时间  
        connector.setConnectTimeout(30);  
          
        //连接到服务器  
        ConnectFuture future = connector.connect(new InetSocketAddress("192.168.2.201",31024));  
          
        future.awaitUninterruptibly();  
        future.getSession().getCloseFuture().awaitUninterruptibly();  
        connector.dispose();  
	}
}
