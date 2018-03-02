package com.folish.socket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint("/webSocket2")
@Component
public class MyWebSocket {
	
	private static Integer onlineCount = 0;

	public static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
	
	private Session session;
	
	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		webSocketSet.add(this);
		addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
	}
	@OnClose
	public void onClose(){
		webSocketSet.remove(this);
		subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}
	@OnError
	public void onError(Session session, Throwable error){
		System.out.println("发生错误");
		error.printStackTrace();
	}
	@OnMessage
	public void onMessage(Session session, String message){
		System.out.println("来自客户端的消息:" + message);
		for (MyWebSocket webSocket : webSocketSet) {
			webSocket.sendMessage(message);
		}
	}
	public void sendMessage(String message){
		synchronized (this.session) {
			try {
				this.session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
