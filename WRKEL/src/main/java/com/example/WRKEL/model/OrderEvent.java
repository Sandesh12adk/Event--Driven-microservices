package com.example.WRKEL.model;

import lombok.Data;

@Data
public class OrderEvent {
    private long productId;
    private String name;
    private int quantity;
}