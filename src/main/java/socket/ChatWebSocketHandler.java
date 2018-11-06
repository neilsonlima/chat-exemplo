package socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ChatWebSocketHandler {
	private String sender;
	private String msg;

	@OnWebSocketConnect
	public void onConnect(Session user) throws Exception{
		String username = "User " + ChatApplication.nextUser++;
		ChatApplication.users.put(user, username);
		ChatApplication.broadcastMessage(sender = "Server", msg = (username + " joined the chat"));
	}
	@OnWebSocketClose
	public void onClose(Session user, int statusCode, String reason) {
		String username = ChatApplication.users.get(user);
		ChatApplication.users.remove(user);
		ChatApplication.broadcastMessage(sender = "Server", msg = (username + " left the chat"));
	}

	@OnWebSocketMessage
	public void onMessage(Session user, String message) {
		ChatApplication.broadcastMessage(sender = ChatApplication.users.get(user), msg = message);
	}	
}
