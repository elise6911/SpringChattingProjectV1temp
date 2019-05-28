package com.kccistc.spring.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public interface WebSocketHandler {
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception;
	public void afterConnectionEstablished(WebSocketSession session) throws Exception;
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception;
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception;
	public boolean supportsPartialMessages();
}
