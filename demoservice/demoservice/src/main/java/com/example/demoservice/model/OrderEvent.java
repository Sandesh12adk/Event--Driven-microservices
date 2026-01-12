package com.example.demoservice.model;
import lombok.Data;

@Data
public class OrderEvent {
    private long productId;
    private String name;
    private int quantity;
}