package socket;

import static j2html.TagCreator.article;
import static j2html.TagCreator.attrs;
import static j2html.TagCreator.b;
import static j2html.TagCreator.p;
import static j2html.TagCreator.span;
import static spark.Spark.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.websocket.api.Session;
import org.json.JSONObject;

import controller.UserController;

public class ChatApplication {

	static Map<Session, String> users = new ConcurrentHashMap<>();
	static int nextUser = 1;

	public static void main(String[] args) {

		staticFileLocation("/public");
		staticFiles.expireTime(600);

		webSocket("/api/chat", ChatWebSocketHandler.class);
		new UserController();
        init();		
	}

	public static void broadcastMessage(String sender, String message) {
		users.keySet().stream().filter(Session::isOpen).forEach(session -> {
			try {
				session.getRemote().sendString(String.valueOf(
						new JSONObject()
						.put("userMessage", createHtmlMessageFromSender(sender, message))
						.put("userList", users.values())

						));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	private static String createHtmlMessageFromSender(String sender, String message) {
		return article().with(
			b(sender + " diz:"),
			p(message),
			span(attrs(".timestamp"), new SimpleDateFormat("HH:mm:ss").format(new Date()))
		).render();
	}

}
