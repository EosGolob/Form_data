package com.eos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.eos.webSocketHandler.NotificationWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		 registry.addHandler(new NotificationWebSocketHandler(), "/notifications").setAllowedOrigins("http://localhost:3000","http://20.193.159.186:3000");
	}

	 @Bean
	    public NotificationWebSocketHandler notificationWebSocketHandler() {
	        return new NotificationWebSocketHandler();
	    }
}
