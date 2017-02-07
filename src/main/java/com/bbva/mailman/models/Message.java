package com.bbva.mailman.models;

import java.io.Serializable;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String body;
	private int priority;
	private boolean secret;
	
	public Message(){
		
	}
	
	public Message(String body, int priority, boolean secret) {
		this.body = body;
		this.priority = priority;
		this.secret = secret;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "Message [body=" + body + ", priority=" + priority + ", secret="
				+ secret + "]";
	}

}
