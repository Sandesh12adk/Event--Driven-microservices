package com.example.WRKEL.controller;

import com.example.WRKEL.model.Message;
import com.example.WRKEL.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
   // @Autowired
   // private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private MessageProducer producer;
    @MessageMapping("/send")
    public void sendMessage(@Payload Message message){
        String strMessage= message.getMessage();
        producer.sendMessage("my-topic",strMessage);
   // simpMessagingTemplate.convertAndSend("/topic",message.getMessage());
    }
}
