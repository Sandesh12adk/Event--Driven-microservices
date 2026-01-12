package com.example.WRKEL.service;

import com.example.WRKEL.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class MessageProducer {
    private static final Logger logger= LoggerFactory.getLogger(MessageProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate0;
    @Autowired
    private ObjectMapper objectMapper;

    public MessageProducer(@Qualifier("producerFactor2") KafkaTemplate<String, byte[]> kafkaTemplate,
                           KafkaTemplate<String, String> kafkaTemplate0) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate0= kafkaTemplate0;
    }

    public void sendEvent(String topic, OrderEvent orderEvent){
        byte[] data = objectMapper.writeValueAsBytes(orderEvent);
        kafkaTemplate.send(topic, data);
        logger.info("OrderEvent Sent " + orderEvent.toString());
    }

    public void sendMessage(String s, String strMessage) {
        kafkaTemplate0.send(s,strMessage);
    }
}

