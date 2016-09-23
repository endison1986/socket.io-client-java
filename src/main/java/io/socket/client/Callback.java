package io.socket.client;

import io.socket.emitter.Emitter;

/**
 * Created by tony on 2016/9/23.
 */
public abstract class Callback implements Emitter.Listener {
	private Session session;
	@Override
	public void call(Object... objects) {
		callback(session, objects);
	}

	void setSession(Session session) {
		this.session = session;
	}

	public abstract void callback(Session session, Object... objects);
}
