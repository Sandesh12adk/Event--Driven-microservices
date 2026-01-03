package com.example.WRKEL.controller;

import com.example.WRKEL.service.MessageProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private final MessageProducer producer;
    private  Test(MessageProducer producer){
        this.producer= producer;
    }
    @PostMapping("/send")
    public void sendToKafkaTopic(@RequestParam String message){
        producer.sendMessage("my-topic",message);
    }
}
