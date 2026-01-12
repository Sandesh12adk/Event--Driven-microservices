package com.example.demoservice.service;

import com.example.demoservice.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class KafkaListen {
    Logger logger= LoggerFactory.getLogger(KafkaListen.class);
    @KafkaListener(
            topics = "order",
            containerFactory = "kafkaListenerContainerFactory"
    )
  public void listen(byte[] order){
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            OrderEvent orderEvent = objectMapper.readValue(order, OrderEvent.class);
            logger.info(orderEvent.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
  }
}
