package com.barreragerman.orderservice.utils;

import com.barreragerman.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionalResponse {

    private Order order;
    private double amount;
    private String transactionId;
    private String message;

}
