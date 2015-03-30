package demo.websocket.handler;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		TextMessage returnMessage = new TextMessage(message.getPayload()
				+ " received at server");
		session.sendMessage(returnMessage);
	}
}
