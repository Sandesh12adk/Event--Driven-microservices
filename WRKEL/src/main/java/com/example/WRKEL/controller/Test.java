package com.example.WRKEL.controller;

import com.example.WRKEL.model.OrderEvent;
import com.example.WRKEL.service.MessageProducer;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/send_order_event")
    public void sendOrderEventToKafka(@RequestBody OrderEvent orderEvent){
        producer.sendEvent("order", orderEvent);
    }
}
