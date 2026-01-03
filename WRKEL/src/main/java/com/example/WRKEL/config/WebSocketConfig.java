package com.example.WRKEL.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Subscribe to path followed by /topic
        registry.enableSimpleBroker("/topic");
        // Send messaage to path follower by app/controller_path
        registry.setApplicationDestinationPrefixes("/app");
    }
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Connect to this endpiont
        registry.addEndpoint("/connect").setAllowedOriginPatterns("*").withSockJS();
    }
}
