package io.socket.client;

import io.socket.emitter.Emitter;

import java.net.InetSocketAddress;

/**
 * Created by tony on 2016/9/23.
 */
public class Session {
	private Socket socket;
	private String eventName;

	public Session(String eventName, Socket socket) {
		this.socket = socket;
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void emit(String eventName, Object... values){
		socket.emit(eventName, values);
	}

	public void close(){
		socket.disconnect();
		socket.close();
	}

	public boolean isConnected(){
		return socket.io().readyState == Manager.ReadyState.OPEN && socket.connected();
	}

	public boolean isStoped(){
		return !socket.connected() && socket.io().readyState == Manager.ReadyState.CLOSED;
	}

	public boolean isConnecting(){
		return socket.io().readyState == Manager.ReadyState.OPENING;
	}

	public InetSocketAddress getRemoteAddress(){
		return socket.getRemoteAddress();
	}
}
